package com.tahauddin.syed.configuration.batch.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class StepConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;


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
}
