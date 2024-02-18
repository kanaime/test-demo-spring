package com.example.demo.controller;

import com.example.demo.models.Customer;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = {"*"})
public class CustomerController {


    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @GetMapping
    public List<Customer> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        Customer customerDB = service.findById(id);
        if (customerDB == null) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        return service.update(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
