package api.island.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import api.island.api.entity.Customer;
import api.island.api.service.CustomerService;

//@RestController
@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
	
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers(); // Clear method name

        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(customers); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){

        Customer customers = this.customerService.getCustomerById(id);
        return ResponseEntity.ok(customers); 
    }
	
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = this.customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer); 
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
    	 return ResponseEntity.ok(this.customerService.customerDelete(id)); 
	}
    
}
