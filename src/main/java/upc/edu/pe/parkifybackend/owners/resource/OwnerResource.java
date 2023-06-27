package upc.edu.pe.parkifybackend.owners.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResource {
    private Long id;
    private String email;
    private String password;
}
