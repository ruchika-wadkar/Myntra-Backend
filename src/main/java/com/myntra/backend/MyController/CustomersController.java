package com.myntra.backend.MyController;


import com.myntra.backend.Entities.Customer;
import com.myntra.backend.Services.CustomerService;
import com.myntra.backend.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController  //Annotations (JAVA 5 feature)
@CrossOrigin
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/api/v1/customer")
    ResponseEntity<List<Customer>> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/api/v1/customer")
    ResponseEntity<String> addCustomer(@RequestBody @Valid List<CustomerVo> customers)  {
        customerService.addCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/customer")
    ResponseEntity<String> updateCustomer(@RequestBody @Valid List<CustomerVo> customers)  {
        customerService.updateCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/customer/{pid}")
    ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Integer pid){
        customerService.deleteCustomer(pid);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
