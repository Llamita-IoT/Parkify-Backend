package upc.edu.pe.parkifybackend.payments.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdatePaymentResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Number cost;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long customerId;
}
