package upc.edu.pe.parkifybackend.customers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.parkifybackend.customers.domain.model.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Override
    List<Customer> findAll();
}
