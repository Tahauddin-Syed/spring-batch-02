package com.tahauddin.syed.configuration.batch.step.constants;

public class SQLConstant {

    public static final String  CUSTOMER_INSERT_QUERY = """
            
            insert into CUSTOMER_TABLE 
            (
            id,
            first_name, 
            last_name, 
            email,
            credit_card_company,
            created_date,
            ip_address,
            ssn
            )
            
            values(
            :id, 
            :first_name, 
            :last_name, 
            :email,
            :credit_card_company,
            :created_date,
            :ip_address,
            :ssn 
            )
             
            
            """;
}
