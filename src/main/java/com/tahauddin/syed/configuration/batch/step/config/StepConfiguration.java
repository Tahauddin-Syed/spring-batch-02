package com.tahauddin.syed.configuration.batch.step.config;

import com.tahauddin.syed.configuration.batch.step.listener.CustomerListener;
import com.tahauddin.syed.configuration.batch.step.processor.CustomerCsvToEntityProcessor;
import com.tahauddin.syed.configuration.dto.CustomerDTO;
import com.tahauddin.syed.dto.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class StepConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final CustomerListener customerListener;

    @Qualifier("CustomerCsvReader")
    private final FlatFileItemReader<CustomerDTO> flatFileItemReader;

    @Qualifier("CustomerJDBCWriter")
    private final JdbcBatchItemWriter<CustomerEntity> batchItemWriter;

    @Qualifier("CustomerCsvToEntityProcessor")
    private final CustomerCsvToEntityProcessor customerCsvToEntityProcessor;


    @Bean
    public StepBuilder stepBuilder() {
        return new StepBuilder("stepThree", jobRepository);
    }


    @Bean
    public Step stepOne() {
        return stepBuilder()
                .<CustomerDTO, CustomerEntity>chunk(150, platformTransactionManager)
                .reader(flatFileItemReader)
                .processor(customerCsvToEntityProcessor)
                .writer(batchItemWriter)
                .listener(customerListener)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(1)
                .build();
    }
}
