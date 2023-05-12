package com.tahauddin.syed.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Bean
    public  JobBuilder jobBuilder(JobRepository jobRepository){
        return new JobBuilder("jobOne", jobRepository);
    }

    @Bean
    public DataSource dataSource(){
        return new MysqlDataSource();
    }

    @Bean
    public TransactionManager transactionManager(){
        // return TestContextTransactionUtils.retrieveTransactionManager(testContext, "transactionManager");
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils(){
        return new JobLauncherTestUtils();
    }
}

