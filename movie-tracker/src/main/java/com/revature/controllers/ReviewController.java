package com.revature.controllers;

import java.util.ArrayList;

import com.revature.data.Review;
import com.revature.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ReviewController
 */
@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/postreview")
    public ArrayList<Review> postReview(@RequestBody Review review) {
        ArrayList<Review> list = new ArrayList<Review>();
        // Review review = new
        // Review(userRepository.findByUsername(username).getUserid(), movie, rating,
        // LocalDateTime.now(), review_body);
        list.add(reviewRepository.postReview(review));
        return list;
    }

    // @RequestMapping("/postreview")
    // public ArrayList<Review> postReview(HttpServletRequest request) {
    // ArrayList<Review> list = new ArrayList<Review>();
    // Review review = new
    // Review(userRepository.findByUsername(request.getParameter("username")).getUserid(),
    // request.getParameter("movie"),
    // Integer.parseInt(request.getParameter("rating")), LocalDateTime.now(),
    // request.getParameter("review_body"));
    // list.add(reviewRepository.postReview(review));
    // return list;
    // }

    @RequestMapping("/myreviews")
    public ArrayList<Review> myReviews(@RequestParam(name = "username") String username) {
        ArrayList<Review> list;
        list = (ArrayList<Review>) reviewRepository.listAllByUsername(username);
        return list;
    }
}