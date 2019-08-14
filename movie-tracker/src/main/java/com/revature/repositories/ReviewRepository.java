package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.revature.data.Review;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
/**
 * ReviewRepository
 */
public class ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public Review postReview(Review review) {
        getSession().persist("Review", review);
        return review;
    }

    @SuppressWarnings("unchecked")
    public List<Review> listAllByUsername(String username) {
        List<Review> reviews = new ArrayList<Review>();

        reviews = getSession().createQuery("from Review where usern = :un").setParameter("un", username).list();
        return reviews;
    }
}