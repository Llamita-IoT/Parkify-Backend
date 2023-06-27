package upc.edu.pe.parkifybackend.customers.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("customerMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public CustomerMapper customerMapper(){
        return new CustomerMapper();
    }
}
