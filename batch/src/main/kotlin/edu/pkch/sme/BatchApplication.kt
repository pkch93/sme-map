package edu.pkch.sme

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableBatchProcessing
class BatchApplication

fun main(args: Array<String>) {
    SpringApplication.run(BatchApplication::class.java, *args)
}