package api.island.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.island.api.entity.Customer;
import api.island.api.repository.CustomerRepository;
import api.island.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	 @Autowired
	 private CustomerRepository customerRepository;
	 
	 @Override
	    public List<Customer> findAllCustomers() {
	        try {
	            return customerRepository.findAll();
	           
	        } catch (Exception e) {
	            throw e;
	        }
	    }
}
