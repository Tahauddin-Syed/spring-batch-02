package com.tahauddin.syed.configuration.batch.step.writer;


import com.tahauddin.syed.dto.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static com.tahauddin.syed.configuration.batch.step.constants.SQLConstant.CUSTOMER_INSERT_QUERY;
import static com.tahauddin.syed.configuration.batch.step.constants.SQLConstant.CUSTOMER_UPDATE_QUERY;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CustomerJdbcItemWriter  {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Bean("CustomerJDBCWriter")
    public JdbcBatchItemWriter<CustomerEntity> writer(){
        JdbcBatchItemWriter<CustomerEntity> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql(CUSTOMER_INSERT_QUERY);
        BeanPropertyItemSqlParameterSourceProvider<CustomerEntity> parameterSourceProvider = new BeanPropertyItemSqlParameterSourceProvider<>();
        batchItemWriter.setItemSqlParameterSourceProvider(parameterSourceProvider);

        return batchItemWriter;
    }



}
