package pe.upc.edu.parkifybackend.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class ReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String review;
    private Integer parkingSpot_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getParkingSpot_id() {
        return parkingSpot_id;
    }

    public void setParkingSpot_id(Integer parkingSpot_id) {
        this.parkingSpot_id = parkingSpot_id;
    }
}