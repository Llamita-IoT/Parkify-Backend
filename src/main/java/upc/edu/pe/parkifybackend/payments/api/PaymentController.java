package upc.edu.pe.parkifybackend.payments.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.parkifybackend.payments.domain.service.PaymentService;
import upc.edu.pe.parkifybackend.payments.mapping.PaymentMapper;
import upc.edu.pe.parkifybackend.payments.resource.CreationPaymentResource;
import upc.edu.pe.parkifybackend.payments.resource.PaymentResource;

@Tag(name = "Payment", description = "Payment information")
@RestController
@RequestMapping(value = "api/v1/payments")
public class PaymentController {

    private final PaymentService service;
    private final PaymentMapper mapper;

    public PaymentController(PaymentService service, PaymentMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<PaymentResource> getAllPayments(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{paymentId}")
    public PaymentResource getPaymentById(@PathVariable("paymentId") Long paymentId){
        return mapper.toResource(service.getById(paymentId));
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(CreationPaymentResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
