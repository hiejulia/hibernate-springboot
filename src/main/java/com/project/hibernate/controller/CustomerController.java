package com.project.hibernate.controller;


import java.util.Map;

import com.project.hibernate.entity.Customer;
import com.project.hibernate.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private ICustomerRepository customerRepository;

    @RequestMapping("/save")
    public String save() {
        // save a single Customer
        customerRepository.save(new Customer("A","B"));
        customerRepository.save(new Customer( "Adam", "Johnson"));
        customerRepository.save(new Customer( "Kim", "Smith"));
        customerRepository.save(new Customer( "David", "Williams"));
        customerRepository.save(new Customer("Peter", "Davis"));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";
        Map<Long, Customer> customers = customerRepository.findAll();

        for (Customer customer : customers.values()) {
            result += customer.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/find")
    public String findById(@RequestParam("id") Long id) {
        String result = "";
        result = customerRepository.find(id).toString();
        return result;
    }

    @RequestMapping(value = "/uppercase")
    public String postCustomer(@RequestParam("id") Long id) {
        Customer customer = customerRepository.find(id);
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customer.setLastName(customer.getLastName().toUpperCase());

        customerRepository.update(customer);

        return "Done";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Long id) {
        customerRepository.delete(id);

        return "Done";
    }
}