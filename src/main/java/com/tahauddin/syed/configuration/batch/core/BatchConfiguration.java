package com.tahauddin.syed.configuration.batch.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class BatchConfiguration implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job job;

    public void runJob() throws Exception{
        jobLauncher.run(job, new JobParametersBuilder()
                .addDate("todaysDate", new Date())
                .toJobParameters());
    }

    @Override
    public void run(String... args) throws Exception {
        runJob();
    }
}
