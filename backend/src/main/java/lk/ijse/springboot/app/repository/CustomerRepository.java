package lk.ijse.springboot.app.repository;


import lk.ijse.springboot.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT count(c.id) FROM Customer c")
    long getTotalCustomers();


}
