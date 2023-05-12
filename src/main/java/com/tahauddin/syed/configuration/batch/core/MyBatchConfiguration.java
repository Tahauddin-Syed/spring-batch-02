package com.tahauddin.syed.configuration.batch.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class MyBatchConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    @Bean
    public JobBuilder jobBuilder() {
        return new JobBuilder("jobOne", jobRepository);
    }

    @Bean
    public StepBuilder stepBuilder() {
        return new StepBuilder("stepOne", jobRepository);
    }

    @Bean
    public Step stepOne() {
        return stepBuilder()
                .tasklet((contribution, chunkContext) -> RepeatStatus.FINISHED)
                .transactionManager(platformTransactionManager)
                .build();
    }

    @Bean
    public Job job() {
        return jobBuilder()
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .build();
    }


}
