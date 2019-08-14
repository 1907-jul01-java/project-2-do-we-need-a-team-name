package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.revature.data.MovieTracker;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MovieTrackerRepo {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void updateMyMovieTracker(){
        
    }

    public MovieTracker postMovie(MovieTracker movieTracker){
        getSession().persist("MovieTracker", movieTracker);
        return movieTracker;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<MovieTracker> listAllFromUsername( String username ){
        List<MovieTracker> tracks = new ArrayList<MovieTracker>();
        tracks = getSession().createQuery("from movie_tracker where username = :un").setParameter("un", username).list();
        return tracks;
    }

}