package com.VueCrudApplication.Service;

import com.VueCrudApplication.Dto.CustomerCreateDto;
import com.VueCrudApplication.Dto.CustomerViewDto;

import java.util.List;

public interface CustomerService {
    public CustomerViewDto getCustomer(String id);
    public List<CustomerViewDto> getAllCustomers();
    public CustomerViewDto saveCustomer(CustomerCreateDto customerCreateDto);
    public CustomerViewDto updateCustomer(String id,CustomerViewDto customerViewDto);
    public void deleteCustomer(String id);
}
