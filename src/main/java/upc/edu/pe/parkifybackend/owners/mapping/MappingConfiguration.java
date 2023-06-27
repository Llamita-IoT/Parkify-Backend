package upc.edu.pe.parkifybackend.owners.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ownerMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public OwnerMapper ownerMapper(){
        return new OwnerMapper();
    }
}
