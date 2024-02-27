package api.island.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@Override
	public Customer getCustomerById(Long id) {
		try {
			return customerRepository.findById(id).get();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Customer createCustomer(Customer customer) {
		try {
			return customerRepository.save(customer);
		} catch (Exception e) {
			throw e;	
		}
		
	}

	@Override
	public ResponseEntity<?> customerDelete(Long id) {
	    try {
	        customerRepository.deleteById(id);
	        return ResponseEntity.ok().build(); 
	    } catch (Exception e) {
	
	        throw e;
	    }
	}

}
