package upc.edu.pe.parkifybackend.parkingslots.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("parkingSlotMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ParkingSlotMapper parkingSlotMapper(){
        return new ParkingSlotMapper();
    }
}
