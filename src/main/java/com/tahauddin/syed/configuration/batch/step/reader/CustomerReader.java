package com.tahauddin.syed.configuration.batch.step.reader;

import com.tahauddin.syed.configuration.dto.CustomerDTO;
import org.springframework.batch.item.database.support.OraclePagingQueryProvider;
import org.springframework.batch.item.database.support.PostgresPagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import java.io.IOException;

import static org.springframework.batch.item.file.transform.DelimitedLineTokenizer.DELIMITER_COMMA;

@Configuration
public class CustomerReader {
    @Value("classpath:data.csv")
    private Resource resource;

    @Bean("CustomerCsvReader")
    public FlatFileItemReader<CustomerDTO> reader() throws IOException {
        FlatFileItemReader<CustomerDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setLinesToSkip(1);
        DefaultLineMapper<CustomerDTO> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(DELIMITER_COMMA);
        delimitedLineTokenizer.setNames("first_name", "last_name", "email", "credit_card_company", "created_date", "ip_address", "ssn");
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        BeanWrapperFieldSetMapper<CustomerDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(CustomerDTO.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        flatFileItemReader.setLineMapper(lineMapper);



        return flatFileItemReader;
    }

    private OraclePagingQueryProvider oraclePagingQueryProvider(){

        final OraclePagingQueryProvider queryProvider = new OraclePagingQueryProvider();

        queryProvider.generateFirstPageQuery(500);

        return queryProvider;
    }

}
