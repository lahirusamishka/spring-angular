package lk.ijse.springboot.app.repository;

import lk.ijse.springboot.app.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepositry extends JpaRepository<Items,String> {

    @Query("SELECT count(i.code) FROM Items i")
    long getTotalItems();
}
