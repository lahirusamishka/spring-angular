package lk.ijse.springboot.app.repository;


import lk.ijse.springboot.app.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Integer> {
}
