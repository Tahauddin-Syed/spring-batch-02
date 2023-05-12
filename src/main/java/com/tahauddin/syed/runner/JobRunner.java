package com.tahauddin.syed.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JobRunner implements CommandLineRunner {
/*
    private final JobLauncher jobLauncher;
    private final Job job;*/

    @Override
    public void run(String... args) throws Exception {
    //    jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
    }
}
