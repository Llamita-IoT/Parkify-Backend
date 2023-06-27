package upc.edu.pe.parkifybackend.parkingslots.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdateParkingSlotResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 5)
    private Number rating;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long customerId;
}
