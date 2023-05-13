package com.tahauddin.syed.configuration.batch.step.writer;


import com.tahauddin.syed.configuration.dto.CustomerDTO;
import com.tahauddin.syed.dto.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CustomerJdbcItemWriter  {

    private final DataSource dataSource;

    @Bean("CustomerJDBCWriter")
    public JdbcBatchItemWriter<CustomerEntity> writer(){
        JdbcBatchItemWriter<CustomerEntity> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);


        return batchItemWriter;
    }



}
