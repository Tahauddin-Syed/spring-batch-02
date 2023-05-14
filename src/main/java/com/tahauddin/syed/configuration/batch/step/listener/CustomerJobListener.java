package com.tahauddin.syed.configuration.batch.step.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class CustomerJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
      log.info("Before Job Execution Time :: {}", LocalDateTime.now());
      log.info("Before Job Execution Status :: {}", jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("After Job Execution Time :: {}", LocalDateTime.now());
        log.info("After Job Execution Status :: {}", jobExecution.getStatus());
    }

}
