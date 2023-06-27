package upc.edu.pe.parkifybackend.payments.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import upc.edu.pe.parkifybackend.payments.domain.model.entity.Payment;
import upc.edu.pe.parkifybackend.payments.domain.persistence.PaymentRepository;
import upc.edu.pe.parkifybackend.payments.domain.service.PaymentService;
import upc.edu.pe.parkifybackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.parkifybackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final String ENTITY = "Payment";

    private final PaymentRepository paymentRepository;

    private final Validator validator;

    public PaymentServiceImpl(PaymentRepository paymentRepository, Validator validator){
        this.paymentRepository = paymentRepository;
        this.validator = validator;
    }

    @Override
    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    @Override
    public Page<Payment> getAll(Pageable pageable){
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Payment getById(Long id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Payment create(Payment payment){
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return paymentRepository.save(payment);
    }
}
