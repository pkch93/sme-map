package edu.pkch.sme.batch

import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@SpringBatchTest
abstract class BatchTest {
    @Autowired
    protected lateinit var jobLauncherTestUtils: JobLauncherTestUtils
}