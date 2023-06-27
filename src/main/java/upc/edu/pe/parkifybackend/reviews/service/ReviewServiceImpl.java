package upc.edu.pe.parkifybackend.reviews.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import upc.edu.pe.parkifybackend.reviews.domain.model.entity.Review;
import upc.edu.pe.parkifybackend.reviews.domain.persistence.ReviewRepository;
import upc.edu.pe.parkifybackend.reviews.domain.service.ReviewService;
import upc.edu.pe.parkifybackend.shared.exception.ResourceNotFoundException;
import upc.edu.pe.parkifybackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final String ENTITY = "Review";

    private final ReviewRepository reviewRepository;

    private final Validator validator;

    public ReviewServiceImpl(ReviewRepository reviewRepository, Validator validator){
        this.reviewRepository = reviewRepository;
        this.validator = validator;
    }

    @Override
    public List<Review> getAll(){
        return reviewRepository.findAll();
    }

    @Override
    public Page<Review> getAll(Pageable pageable){
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Review getById(Long id){
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Review create(Review review){
        Set<ConstraintViolation<Review>> violations = validator.validate(review);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reviewRepository.save(review);
    }
}
