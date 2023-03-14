package edu.pkch.sme.batch

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.sql.DataSource

@SpringBootApplication
@EnableBatchProcessing
class BatchApplication

fun main(args: Array<String>) {
    SpringApplication.run(BatchApplication::class.java, *args)
}