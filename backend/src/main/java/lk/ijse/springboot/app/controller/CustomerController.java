package lk.ijse.springboot.app.controller;


import lk.ijse.springboot.app.dto.CustomerDTO;
import lk.ijse.springboot.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomer(@PathVariable("id") String customerID) {
        return service.getCustomer(customerID);
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public CustomerDTO getCustomer1(@RequestParam("id")  String id){
//        return service.getCustomer(id);
//    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCustomer(@PathVariable("id") String customerId) {
        return service.deleteCustomer(customerId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody CustomerDTO customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCustomersCount(){
        return service.getTotalCustomers();
    }


}
