package com.tahauddin.syed.configuration.batch.job;

import com.tahauddin.syed.configuration.batch.step.listener.CustomerJobListener;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

    private final JobRepository jobRepository;
    private final CustomerJobListener customerJobListener;

    @Bean
    public JobBuilder jobBuilder() {
        return new JobBuilder("jobOne", jobRepository);
    }

    @Bean
    public Job jobOne(Step stepOne) {
        return jobBuilder()
                .listener(customerJobListener)
                .incrementer(new RunIdIncrementer())
                .start(stepOne)
                .build();
    }
}
