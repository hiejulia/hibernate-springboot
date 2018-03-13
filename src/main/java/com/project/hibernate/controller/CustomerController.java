package com.project.hibernate.controller;


import java.util.Map;
import java.util.Optional;

import com.project.hibernate.entity.Customer;
import com.project.hibernate.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/v1/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerRepository customerRepository;

//    @RequestMapping("/save")
//    public String save() {
//        // save a single Customer
//        customerRepository.save(new Customer("A","B"));
//        customerRepository.save(new Customer( "Adam", "Johnson"));
//        customerRepository.save(new Customer( "Kim", "Smith"));
//        customerRepository.save(new Customer( "David", "Williams"));
//        customerRepository.save(new Customer("Peter", "Davis"));
//
//        return "Done";
//    }
//
//    @RequestMapping("/findall")
//    public String findAll() {
//        String result = "";
//        Map<Long, Customer> customers = customerRepository.findAll();
//
//        for (Customer customer : customers.values()) {
//            result += customer.toString() + "<br>";
//        }
//
//        return result;
//    }
//
//    @RequestMapping("/find")
//    public String findById(@RequestParam("id") Long id) {
//        String result = "";
//        result = customerRepository.find(id).toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/uppercase")
//    public String postCustomer(@RequestParam("id") Long id) {
//        Customer customer = customerRepository.find(id);
//        customer.setFirstName(customer.getFirstName().toUpperCase());
//        customer.setLastName(customer.getLastName().toUpperCase());
//
//        customerRepository.update(customer);
//
//        return "Done";
//    }
//
//    @RequestMapping("/delete")
//    public String deleteById(@RequestParam("id") Long id) {
//        customerRepository.delete(id);
//
//        return "Done";
//    }
@Cacheable(value = "customer", key = "#customerId")
//@CachePut(value = "customer", key = "#customerId")
@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
public Optional<Customer> getCustomer(@PathVariable Long customerId) {


    return customerRepository.findById(customerId);

}

    @CachePut(value = "customer", key = "#customer.id")
    @PutMapping
    public Customer updateCustomerByID(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
//    @CacheEvict(value = "users", allEntries=true)
//    @DeleteMapping("/{id}")
//    public void deleteUserByID(@PathVariable Long id) {
//        LOG.info("deleting person with id {}", id);
//        userRepository.delete(id);
//    }


}