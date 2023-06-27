package upc.edu.pe.parkifybackend.customers.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResource {
    private Long id;
    private String email;
    private String password;
}
