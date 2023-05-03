package pe.upc.edu.parkifybackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.edu.parkifybackend.models.ReviewModel;
import pe.upc.edu.parkifybackend.repositories.ReviewRepository;

import java.util.ArrayList;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public ArrayList<ReviewModel> getReview(){
        return (ArrayList<ReviewModel>) reviewRepository.findAll();
    }

    public ReviewModel saveReview(ReviewModel review){
        return reviewRepository.save(review);
    }

    public boolean deleteReview(Long id){
        try {
            reviewRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}