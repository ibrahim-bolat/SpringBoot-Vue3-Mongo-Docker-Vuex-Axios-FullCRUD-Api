package com.VueCrudApplication.Dto;

import com.VueCrudApplication.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerViewDto {
        private String customerId;
        private String customerName;
        private String customerSurName;
        private String language;
        private String gender;
        private String phoneNumber;
        private String email;
        private LocalDate birthofDate;

        public static CustomerViewDto of(Customer customer){
                CustomerViewDto newCustomerViewDto=new CustomerViewDto(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerSurName(),
                        customer.getLanguage(),customer.getGender().getGenderText(),customer.getPhoneNumber(),customer.getEmail(), customer.getBirthofDate());
                return newCustomerViewDto;
        }


}
