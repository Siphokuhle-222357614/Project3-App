package za.co.admatech.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Review {
    private final String reviewId;
    private final String jobId;
    private final String reviewerId;
    private final int rating; // 1-5
    private final String comment;
    private final LocalDate date;

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.jobId = builder.jobId;
        this.reviewerId = builder.reviewerId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.date = builder.date;
    }

    // Getters
    public String getReviewId() { return reviewId; }
    public String getJobId() { return jobId; }
    public String getReviewerId() { return reviewerId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public LocalDate getDate() { return date; }

    // Equals, HashCode, ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return rating == review.rating &&
                Objects.equals(reviewId, review.reviewId) &&
                Objects.equals(jobId, review.jobId) &&
                Objects.equals(reviewerId, review.reviewerId) &&
                Objects.equals(comment, review.comment) &&
                Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, jobId, reviewerId, rating, comment, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", jobId='" + jobId + '\'' +
                ", reviewerId='" + reviewerId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }

    // Builder Pattern
    public static class Builder {
        private String reviewId;
        private String jobId;
        private String reviewerId;
        private int rating;
        private String comment;
        private LocalDate date;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setJobId(String jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder setReviewerId(String reviewerId) {
            this.reviewerId = reviewerId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.jobId = review.jobId;
            this.reviewerId = review.reviewerId;
            this.rating = review.rating;
            this.comment = review.comment;
            this.date = review.date;
            return this;
        }

        public Review build() {
            if (rating < 1 || rating > 5)
                throw new IllegalArgumentException("Rating must be 1-5.");
            if (Helper.isNullOrEmpty(jobId) || Helper.isNullOrEmpty(reviewerId))
                throw new IllegalArgumentException("Job ID and Reviewer ID are required.");
            return new Review(this);
        }
    }
}
