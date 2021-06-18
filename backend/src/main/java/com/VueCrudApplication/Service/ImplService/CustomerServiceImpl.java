package com.VueCrudApplication.Service.ImplService;

import com.VueCrudApplication.Dto.CustomerCreateDto;
import com.VueCrudApplication.Dto.CustomerViewDto;
import com.VueCrudApplication.Enums.Gender;
import com.VueCrudApplication.Model.Customer;
import com.VueCrudApplication.Service.CustomerService;
import com.VueCrudApplication.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerViewDto getCustomer(String id) {
        Customer customer=this.customerRepository.findById(id).get();
        return CustomerViewDto.of(customer);
    }

    @Override
    public List<CustomerViewDto> getAllCustomers() {
        return this.customerRepository.findAll().stream().map(CustomerViewDto::of).collect(Collectors.toList());
    }

    @Override
    public CustomerViewDto saveCustomer(CustomerCreateDto customerCreateDto) {
        Customer newCustomer=CustomerCreateDto.of(customerCreateDto);
        Customer secondCustomer= this.customerRepository.save(newCustomer);
        return  CustomerViewDto.of(secondCustomer);
    }

    @Override
    public CustomerViewDto updateCustomer(String id, CustomerViewDto customerViewDto) {
        if (this.customerRepository.existsById(id)){
            Customer customer=this.customerRepository.findById(id).get();
            customer.setCustomerName(customerViewDto.getCustomerName());
            customer.setCustomerSurName(customerViewDto.getCustomerSurName());
            customer.setLanguage(customerViewDto.getLanguage());
            customer.setGender(Gender.fromString(customerViewDto.getGender()));
            customer.setPhoneNumber(customerViewDto.getPhoneNumber());
            customer.setEmail(customerViewDto.getEmail());
            customer.setBirthofDate(customerViewDto.getBirthofDate());
            return  CustomerViewDto.of(this.customerRepository.save(customer));
        }
        else
        {
           return null;
        }
    }

    @Override
    public void deleteCustomer(String id) {
        this.customerRepository.deleteById(id);
    }

}
