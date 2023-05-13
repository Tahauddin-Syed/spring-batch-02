package com.tahauddin.syed.configuration.batch.step.processor;

import com.tahauddin.syed.configuration.dto.CustomerDTO;
import com.tahauddin.syed.dto.CustomerEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("CustomerCsvToEntityProcessor")
public class CustomerCsvToEntityProcessor implements ItemProcessor<CustomerDTO, CustomerEntity> {

    @Override
    public CustomerEntity process(CustomerDTO item) throws Exception {


        return null;
    }
}
