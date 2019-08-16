package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.revature.data.MovieTracker;

import org.hibernate.HibernateException;
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

    // @Transactional
    // // @SuppressWarnings("unchecked")
    // public void updateMyMovieTracker(MovieTracker movieTracker){
    //     //Update tracked and watched given username and movieid
    //     // List<MovieTracker> track = new ArrayList<MovieTracker>();
    //     getSession().createQuery("UPDATE MovieTracker set watched =:wa"
    //         + " WHERE username = :un and movieid =:id")
    //         .setParameter("wa", movieTracker.getWatched())
    //         .setParameter("un", movieTracker.getUsername())
    //         .setParameter("id", movieTracker.getMovieid())
    //         .list();
    //     getSession().createQuery("UPDATE MovieTracker set tracked =:tr WHERE username = :un and movieid =:id")
    //         .setParameter("tr", movieTracker.getTracked())
    //         .setParameter("un", movieTracker.getUsername())
    //         .setParameter("id", movieTracker.getMovieid());
    //     // return track;
    // }

    public void updateMyMovieTracker(MovieTracker movieTracker){
        getSession().merge("MovieTracker", movieTracker);
    }

    // public MovieTracker postMovie(MovieTracker movieTracker){
    //     getSession().persist("MovieTracker", movieTracker);
    //     return movieTracker;
    // }

    public MovieTracker postMovie(MovieTracker movieTracker){
        try{
            getSession().get("MovieTracker", movieTracker.getId());
        }
        catch (HibernateException e) {
            getSession().persist("MovieTracker", movieTracker);
        }
        return movieTracker;
    }
    
    public void deleteMovieTracker(MovieTracker movieTracker){
        getSession().createQuery("delete MovieTracker where id = :id")
        .setParameter("id", movieTracker.getId())
        .executeUpdate();

    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<MovieTracker> listTrackedFromUsername( String username ){
        List<MovieTracker> tracks = new ArrayList<MovieTracker>();
        tracks = getSession().createQuery("from MovieTracker where username = :un and tracked = :tr")
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