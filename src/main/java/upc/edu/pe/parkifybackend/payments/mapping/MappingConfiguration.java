package upc.edu.pe.parkifybackend.payments.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("paymentMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PaymentMapper paymentMapper(){
        return new PaymentMapper();
    }
}
