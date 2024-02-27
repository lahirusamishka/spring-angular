package api.island.api.service;import java.util.List;

import org.springframework.http.ResponseEntity;

import api.island.api.entity.Customer;

public interface CustomerService {

	List<Customer> findAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);



    ResponseEntity<?> customerDelete(Long id);



}
