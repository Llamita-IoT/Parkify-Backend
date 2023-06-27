package upc.edu.pe.parkifybackend.reviews.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.parkifybackend.reviews.domain.service.ReviewService;
import upc.edu.pe.parkifybackend.reviews.mapping.ReviewMapper;
import upc.edu.pe.parkifybackend.reviews.resource.CreationReviewResource;
import upc.edu.pe.parkifybackend.reviews.resource.ReviewResource;

@Tag(name = "Review", description = "Review information")
@RestController
@RequestMapping(value = "api/v1/reviews")
public class ReviewController {

    private final ReviewService service;
    private final ReviewMapper mapper;

    public ReviewController(ReviewService service, ReviewMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<ReviewResource> getAllReviews(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{reviewId}")
    public ReviewResource getReviewById(@PathVariable("reviewId") Long reviewId){
        return mapper.toResource(service.getById(reviewId));
    }

    @PostMapping
    public ResponseEntity<ReviewResource> createReview(CreationReviewResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
