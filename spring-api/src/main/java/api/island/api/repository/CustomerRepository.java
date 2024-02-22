package api.island.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.island.api.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
