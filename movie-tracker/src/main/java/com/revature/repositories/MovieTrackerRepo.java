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

    @Transactional
    public MovieTracker updateMyMovieTracker(MovieTracker movieTracker){
        //Update tracked and watched given username and movieid
        getSession().createQuery("UPDATE MovieTracker set watched =:wa WHERE username = :un and movieid =:id")
            .setParameter("wa", movieTracker.getWatched())
            .setParameter("un", movieTracker.getUsername())
            .setParameter("id", movieTracker.getMovieid());
        getSession().createQuery("UPDATE MovieTracker set tracked =:tr WHERE username = :un and movieid =:id")
            .setParameter("tr", movieTracker.getTracked())
            .setParameter("un", movieTracker.getUsername())
            .setParameter("id", movieTracker.getMovieid());
        return movieTracker;
    }

    public MovieTracker postMovie(MovieTracker movieTracker){
        getSession().persist("MovieTracker", movieTracker);
        return movieTracker;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<MovieTracker> listTrackedFromUsername( String username ){
        List<MovieTracker> tracks = new ArrayList<MovieTracker>();
        tracks = getSession().createQuery("from MovieTracker t where username = :un and tracked = :tr")
            .setParameter("un", username)
            .setParameter("tr", true)
            .list();
        return tracks;
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<MovieTracker> listWatchedFromUsername( String username ){
        List<MovieTracker> tracks = new ArrayList<MovieTracker>();
        tracks = getSession().createQuery("from MovieTracker where username = :un and watched = :wa")
        .setParameter("un", username)
        .setParameter("wa", true)
        .list();
        return tracks;
    }


}