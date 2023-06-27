package upc.edu.pe.parkifybackend.reviews.resource;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreationReviewResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
