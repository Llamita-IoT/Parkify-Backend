package upc.edu.pe.parkifybackend.payments.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.parkifybackend.payments.domain.model.entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    @Override
    List<Payment> findAll();
}
