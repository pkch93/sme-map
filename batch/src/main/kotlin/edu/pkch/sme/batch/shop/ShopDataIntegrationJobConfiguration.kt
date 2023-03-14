package edu.pkch.sme.batch.shop

import edu.pkch.sme.shop.Shop
import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private val log =  KotlinLogging.logger(ShopDataIntegrationJobConfiguration::class.java.name)

const val JOB_NAME: String = "shopDataIntegrationJob"
private const val STEP_NAME: String = "shopDataIntegrationStep"

@Configuration
@ConditionalOnProperty(name = [ "spring.batch.job.names" ], havingValue = JOB_NAME)
class ShopDataIntegrationJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {
    private val resourcePath: String = "/data.csv"
    private var offset: Int = 1

    @Bean(JOB_NAME)
    fun shopUpToDateJob(): Job {
        return jobBuilderFactory.get(JOB_NAME)
            .preventRestart()
            .incrementer(RunIdIncrementer())
            .start(shopUpToDateStep())
            .build();
    }

    @Bean(STEP_NAME)
    fun shopUpToDateStep(): Step {
        return stepBuilderFactory.get(STEP_NAME)
            .chunk<CsvShop, Shop>(1000)
            .reader(shopDataReader())
            .processor(shopDataProcessor())
            .writer(shopDataWriter())
            .build();
    }

    @Bean
    fun shopDataReader(): ShopDataReader {
        return ShopDataReader(resourcePath, offset)
    }

    @Bean
    fun shopDataProcessor() = ItemProcessor<CsvShop, Shop> {
        log.info { "read shop: $it" }
        it.toShop()
    }

    @Bean
    fun shopDataWriter() = ItemWriter<Shop> {
    }
}