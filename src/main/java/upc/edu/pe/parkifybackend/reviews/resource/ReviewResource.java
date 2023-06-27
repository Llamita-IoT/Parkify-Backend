package upc.edu.pe.parkifybackend.reviews.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResource {
    private Long id;
    private Integer rating;
    private String description;
    private Long customerId;
}
