package upc.edu.pe.parkifybackend.customers.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import upc.edu.pe.parkifybackend.customers.domain.model.entity.Customer;
import upc.edu.pe.parkifybackend.customers.domain.persistence.CustomerRepository;
import upc.edu.pe.parkifybackend.customers.domain.service.CustomerService;
import upc.edu.pe.parkifybackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.parkifybackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String ENTITY = "Customer";

    private final CustomerRepository customerRepository;

    private final Validator validator;

    public CustomerServiceImpl(CustomerRepository customerRepository, Validator validator){
        this.customerRepository = customerRepository;
        this.validator = validator;
    }

    @Override
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getAll(Pageable pageable){
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Customer create(Customer customer){
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return customerRepository.save(customer);
    }
}
