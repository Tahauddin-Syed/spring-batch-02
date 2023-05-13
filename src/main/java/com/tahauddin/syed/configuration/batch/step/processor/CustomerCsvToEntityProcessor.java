package com.tahauddin.syed.configuration.batch.step.processor;

import com.tahauddin.syed.configuration.dto.CustomerDTO;
import com.tahauddin.syed.dto.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("CustomerCsvToEntityProcessor")
@Slf4j
public class CustomerCsvToEntityProcessor implements ItemProcessor<CustomerDTO, CustomerEntity> {

    @Override
    public CustomerEntity process(CustomerDTO item) throws Exception {
        val customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(item, customerEntity);
        customerEntity.setId(UUID.randomUUID().toString());
        log.info("Customer Entity is :: {}", customerEntity);
        return customerEntity;
    }
}
