package upc.edu.pe.parkifybackend.customers.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.parkifybackend.customers.domain.service.CustomerService;
import upc.edu.pe.parkifybackend.customers.mapping.CustomerMapper;
import upc.edu.pe.parkifybackend.customers.resource.CreationCustomerResource;
import upc.edu.pe.parkifybackend.customers.resource.CustomerResource;

@Tag(name = "Customer", description = "Customer account")
@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;

    public CustomerController(CustomerService service, CustomerMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<CustomerResource> getAllCustomers(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{customerId}")
    public CustomerResource getCustomerById(@PathVariable("customerId") Long customerId){
        return mapper.toResource(service.getById(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerResource> createCustomer(CreationCustomerResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
