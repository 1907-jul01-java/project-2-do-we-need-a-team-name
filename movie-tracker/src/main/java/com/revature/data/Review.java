package com.revature.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Review
 */
@Entity
@Table(name = "reviews")
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewid;

    @OneToOne(targetEntity = com.revature.data.User.class)
    @JoinColumn(name = "userid")
    @NotBlank
    private int userid;

    @Column(name = "movie", nullable = false)
    @NotBlank
    private String movie;

    @Column(name = "rating", nullable = false)
    @NotBlank
    private int rating;

    @Column(name = "time_created", nullable = false)
    @NotBlank
    private String time_created;

    @Column(name = "review_body")
    private String review_body;

    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }

    public String getReview_body() {
        return review_body;
    }

    public void setReview_body(String review_body) {
        this.review_body = review_body;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((movie == null) ? 0 : movie.hashCode());
        result = prime * result + rating;
        result = prime * result + ((review_body == null) ? 0 : review_body.hashCode());
        result = prime * result + reviewid;
        result = prime * result + ((time_created == null) ? 0 : time_created.hashCode());
        result = prime * result + userid;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Review other = (Review) obj;
        if (movie == null) {
            if (other.movie != null)
                return false;
        } else if (!movie.equals(other.movie))
            return false;
        if (rating != other.rating)
            return false;
        if (review_body == null) {
            if (other.review_body != null)
                return false;
        } else if (!review_body.equals(other.review_body))
            return false;
        if (reviewid != other.reviewid)
            return false;
        if (time_created == null) {
            if (other.time_created != null)
                return false;
        } else if (!time_created.equals(other.time_created))
            return false;
        if (userid != other.userid)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Review [movie=" + movie + ", rating=" + rating + ", review_body=" + review_body + ", reviewid="
                + reviewid + ", time_created=" + time_created + ", userid=" + userid + "]";
    }

    public Review(int reviewid, int userid, String movie, int rating, String time_created, String review_body) {
        this.reviewid = reviewid;
        this.userid = userid;
        this.movie = movie;
        this.rating = rating;
        this.time_created = time_created;
        this.review_body = review_body;
    }

    public Review() {
        super();
    }
}