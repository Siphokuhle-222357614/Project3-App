package za.co.admatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.admatech.domain.Review;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findByJobId(String jobId);
    List<Review> findByReviewerId(String reviewerId);
}