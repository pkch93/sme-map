package edu.pkch.sme.batch.shop

import edu.pkch.sme.batch.BatchTest
import org.junit.jupiter.api.Test
import org.springframework.test.context.TestPropertySource


@TestPropertySource(properties = [ "spring.batch.job.names=${JOB_NAME}"])
internal class ShopDataIntegrationJobConfigurationTest: BatchTest() {

    @Test
    fun name() {
        jobLauncherTestUtils.launchJob()
    }
}