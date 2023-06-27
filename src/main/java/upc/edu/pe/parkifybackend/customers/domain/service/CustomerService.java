package upc.edu.pe.parkifybackend.customers.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.customers.domain.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Page<Customer> getAll(Pageable pageable);

    Customer getById(Long CustomerId);

    Customer create(Customer customer);
}
