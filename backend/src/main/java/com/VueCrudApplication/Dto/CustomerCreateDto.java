package com.VueCrudApplication.Dto;

import com.VueCrudApplication.Enums.Gender;
import com.VueCrudApplication.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class CustomerCreateDto {

                private String customerId;
                private String customerName;
                private String customerSurName;
                private String language;
                private String gender;
                private String phoneNumber;
                private String email;
                private LocalDate birthofDate;
                private String password;

                public static Customer of(CustomerCreateDto customerCreateDto) {
                        Customer customer = new Customer(customerCreateDto.getCustomerId(), customerCreateDto.getCustomerName(), customerCreateDto.getCustomerSurName()
                                ,customerCreateDto.getLanguage(),Gender.fromString(customerCreateDto.getGender()),customerCreateDto.phoneNumber,customerCreateDto.getEmail(),customerCreateDto.getBirthofDate(),customerCreateDto.getPassword());
                        return customer;
                }
        }



