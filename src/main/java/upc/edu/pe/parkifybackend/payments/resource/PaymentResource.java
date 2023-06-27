package upc.edu.pe.parkifybackend.payments.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResource {
    private Long id;
    private Number cost;
    private Long customerId;
}
