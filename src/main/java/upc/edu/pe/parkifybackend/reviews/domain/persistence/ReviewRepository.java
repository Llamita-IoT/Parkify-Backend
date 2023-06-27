package upc.edu.pe.parkifybackend.reviews.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.parkifybackend.reviews.domain.model.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    @Override
    List<Review> findAll();
}
