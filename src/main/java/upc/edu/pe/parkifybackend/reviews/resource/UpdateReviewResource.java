package upc.edu.pe.parkifybackend.reviews.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdateReviewResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 5)
    private Integer rating;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long customerId;
}
