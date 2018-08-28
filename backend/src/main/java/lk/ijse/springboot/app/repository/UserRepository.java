package lk.ijse.springboot.app.repository;


import lk.ijse.springboot.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {
}
