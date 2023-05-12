package com.tahauddin.syed;

import com.tahauddin.syed.config.BatchConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootTest(classes = BatchConfiguration.class)
class SpringBatch02ApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	void contextLoads() throws Exception {
		jobLauncherTestUtils.launchJob();
	}

}
