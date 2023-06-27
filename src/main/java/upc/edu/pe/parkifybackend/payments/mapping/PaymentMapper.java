package upc.edu.pe.parkifybackend.payments.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.payments.domain.model.entity.Payment;
import upc.edu.pe.parkifybackend.payments.resource.UpdatePaymentResource;
import upc.edu.pe.parkifybackend.shared.mapping.EnhancedModelMapper;
import upc.edu.pe.parkifybackend.payments.resource.CreationPaymentResource;
import upc.edu.pe.parkifybackend.payments.resource.PaymentResource;

import java.io.Serializable;
import java.util.List;

public class PaymentMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public PaymentResource toResource(Payment model){
        return mapper.map(model, PaymentResource.class);
    }

    public Page<PaymentResource> modelListPage(List<Payment> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PaymentResource.class), pageable, modelList.size());
    }

    public Payment toModel(CreationPaymentResource resource){
        return mapper.map(resource, Payment.class);
    }

    public Payment toModel(UpdatePaymentResource resource){
        return mapper.map(resource, Payment.class);
    }
}
