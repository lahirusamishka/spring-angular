package lk.ijse.springboot.app.repository;

import lk.ijse.springboot.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ORderRepository extends JpaRepository<Orders,String> {

    @Query("SELECT count(o.oId) FROM Orders o")
    long getTotalOrders();
}
