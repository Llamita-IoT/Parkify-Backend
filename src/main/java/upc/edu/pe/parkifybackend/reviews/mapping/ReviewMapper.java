package upc.edu.pe.parkifybackend.reviews.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.parkifybackend.reviews.domain.model.entity.Review;
import upc.edu.pe.parkifybackend.reviews.resource.CreationReviewResource;
import upc.edu.pe.parkifybackend.reviews.resource.ReviewResource;
import upc.edu.pe.parkifybackend.reviews.resource.UpdateReviewResource;
import upc.edu.pe.parkifybackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class ReviewMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ReviewResource toResource(Review model){
        return mapper.map(model, ReviewResource.class);
    }

    public Page<ReviewResource> modelListPage(List<Review> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ReviewResource.class), pageable, modelList.size());
    }

    public Review toModel(CreationReviewResource resource){
        return mapper.map(resource, Review.class);
    }

    public Review toModel(UpdateReviewResource resource){
        return mapper.map(resource, Review.class);
    }
}
