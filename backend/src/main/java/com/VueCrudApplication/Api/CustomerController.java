package com.VueCrudApplication.Api;

import com.VueCrudApplication.Dto.CustomerCreateDto;
import com.VueCrudApplication.Dto.CustomerViewDto;
import com.VueCrudApplication.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerViewDto> getCustomer(@PathVariable String id){
        return ResponseEntity.ok(this.customerService.getCustomer(id));
    }
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerViewDto>> getAllCustomers(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @PostMapping("/addCustomer" )
    public ResponseEntity<CustomerViewDto> saveCustomer(@RequestBody CustomerCreateDto customerCreateDto){
        return ResponseEntity.ok(this.customerService.saveCustomer(customerCreateDto));
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<CustomerViewDto> updateCustomer(@PathVariable String id,@RequestBody CustomerViewDto customerViewDto){
        return ResponseEntity.ok(this.customerService.updateCustomer(id,customerViewDto));
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id){
        this.customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
