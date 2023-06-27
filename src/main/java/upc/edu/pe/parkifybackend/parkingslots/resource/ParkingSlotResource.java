package upc.edu.pe.parkifybackend.parkingslots.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotResource {
    private Long id;
    private Integer rating;
    private String description;
    private Long customerId;
}
