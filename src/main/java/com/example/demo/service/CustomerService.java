package com.example.demo.service;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer update(Customer customer) {

        return customerRepository.save(customer);
    }
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
