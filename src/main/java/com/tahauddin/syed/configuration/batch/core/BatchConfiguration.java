/*
package com.tahauddin.syed.configuration.batch.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class BatchConfiguration {

    private final JobRepository jobRepository;

    @Bean
    public JobBuilder jobBuilder(){
        return new JobBuilder("jobOne" , jobRepository);
    }

    @Bean
    public Job job(){
        return jobBuilder()
                .incrementer(new RunIdIncrementer())
                .start(new TaskletStep("stepOne") {
                    @Override
                    protected void doExecute(StepExecution stepExecution) throws Exception {
                        log.info("In Tasklet Method :: {}", stepExecution.getStepName());
                    }
                })
                .build();
    }
}
*/
