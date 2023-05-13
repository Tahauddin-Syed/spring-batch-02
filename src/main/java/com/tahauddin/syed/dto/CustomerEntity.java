package com.tahauddin.syed.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity {

    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String credit_card_company;
    private String created_date;
    private String ip_address;
    private String ssn;



}
