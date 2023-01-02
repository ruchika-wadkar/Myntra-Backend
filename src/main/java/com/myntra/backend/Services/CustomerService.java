package com.myntra.backend.Services;

import com.myntra.backend.Repository.CustomerRepository;
import com.myntra.backend.Entities.Customer;
import com.myntra.backend.Exceptions.*;
import com.myntra.backend.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public ResponseEntity<List<Customer>> getCustomers() {
        //Generics (JAVA 5 feature)
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    public void addCustomer(List<CustomerVo> customers)  {
        for (CustomerVo customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isPresent()) {
                throw new CustomerException("Customer already exists");
            }
            customerRepository.save(getEntity(customer));
        }
    }

    public void updateCustomer(List<CustomerVo> customers)  {
        for (CustomerVo customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isEmpty()) {
                throw new CustomerException("Customer not found");
            }
            customerRepository.save(getEntity(customer));
        }
    }

    public void deleteCustomer(Integer pid){
        customerRepository.delete(customerRepository.findById(pid).orElseThrow(() -> new CustomerException("customer not found with this id")));
    }

    public Customer getEntity(CustomerVo customer){
        Customer C1 = new Customer();
                C1.setCustomerID(customer.getCustomerID());
                C1.setCustomerName(customer.getCustomerName());
                C1.setAddress(customer.getAddress());
                C1.setPostalCode(customer.getPostalCode());
                C1.setCity(customer.getCity());
                C1.setCountry(customer.getCountry());
                return C1;
    }

}
