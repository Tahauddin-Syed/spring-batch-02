package com.tahauddin.syed;

import com.tahauddin.syed.config.BatchConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest(classes = BatchConfiguration.class)
class SpringBatch02ApplicationTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	void contextLoads() throws Exception {
		jobLauncherTestUtils.launchJob();
	}

}
