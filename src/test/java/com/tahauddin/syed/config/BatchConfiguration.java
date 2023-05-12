package com.tahauddin.syed.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.val;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {



    @Bean
    public JobBuilder jobBuilder(){
        val jobBuilder = new JobBuilder("jobOne");
        return jobBuilder;
    }

/*    @Bean
    public DataSource dataSource(){
        return new MysqlDataSource();
    }

    @Bean
    public TransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }*/

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils(){
        return new JobLauncherTestUtils();
    }

    @Bean
    public JobRepositoryTestUtils jobRepositoryTestUtils(){
        val jobRepositoryTestUtils = new JobRepositoryTestUtils();
        return jobRepositoryTestUtils;
    }
}

