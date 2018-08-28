package lk.ijse.springboot.app.service;


import lk.ijse.springboot.app.dto.CustomerDTO;

import java.util.ArrayList;


public interface CustomerService {

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomer(String customerId);

    public boolean deleteCustomer(String customerId);

    public boolean saveCustomer(CustomerDTO customer);

    public long getTotalCustomers();

    public CustomerDTO searchCustomer(String id);

}
