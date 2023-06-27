package upc.edu.pe.parkifybackend.reviews.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.reviews.domain.model.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();

    Page<Review> getAll(Pageable pageable);

    Review getById(Long ReviewId);

    Review create(Review review);
}
