package upc.edu.pe.parkifybackend.reviews.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reviewMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ReviewMapper reviewMapper(){
        return new ReviewMapper();
    }
}
