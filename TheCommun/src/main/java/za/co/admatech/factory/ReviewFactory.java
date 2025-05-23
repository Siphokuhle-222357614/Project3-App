package za.co.admatech.factory;

import za.co.admatech.domain.Review;
import za.co.admatech.util.Helper;
import java.time.LocalDate;

public class ReviewFactory {
    public static Review createReview(String jobId, String reviewerId, int rating, String comment) {
        if (Helper.isNullOrEmpty(jobId) || Helper.isNullOrEmpty(reviewerId) ||
                rating < 1 || rating > 5 || Helper.isNullOrEmpty(comment)) {
            return null;
        }

        String reviewId = Helper.generateId();
        LocalDate date = LocalDate.now();

        return new Review.Builder()
                .setReviewId(reviewId)
                .setJobId(jobId)
                .setReviewerId(reviewerId)
                .setRating(rating)
                .setComment(comment)
                .setDate(date)
                .build();
    }
}
