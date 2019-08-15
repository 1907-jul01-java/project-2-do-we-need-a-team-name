package com.revature.controllers;

import java.util.ArrayList;

import com.revature.data.MovieTracker;
import com.revature.repositories.MovieTrackerRepo;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
// @CrossOrigin("http://localhost:4200")
@RequestMapping("MovieTracker")
public class MovieTrackerController {

    @Autowired
    private MovieTrackerRepo movieTrackerRepository;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getTracked")
    public ArrayList<MovieTracker> getMovieTrackedList(@RequestParam(name = "username") String username){
        ArrayList<MovieTracker> list;
        list = (ArrayList<MovieTracker>) movieTrackerRepository.listTrackedFromUsername(username);
        return list;
    }

    @RequestMapping("/getWatched")
    public ArrayList<MovieTracker> getMovieWatchedList(@RequestParam(name = "username") String username){
        ArrayList<MovieTracker> list;
        list = (ArrayList<MovieTracker>) movieTrackerRepository.listWatchedFromUsername(username);
        return list;
    }

    //Post method for adding a new MovieTracker given 
    @RequestMapping("/postTracker")
    public ArrayList<MovieTracker> postMovieTracker(@RequestBody MovieTracker movieTracker){
        ArrayList<MovieTracker> list = new ArrayList<MovieTracker>();
        list.add(movieTrackerRepository.postMovie(movieTracker));
        return list;
    }

    // @RequestMapping("/updateTracker")
    // public ArrayList<MovieTracker> updateMovieTracker(@RequestBody MovieTracker movieTracker) {
    //     ArrayList<MovieTracker> list = new ArrayList<MovieTracker>();
    //     list = (ArrayList<MovieTracker>) movieTrackerRepository.updateMyMovieTracker(movieTracker);
    //     return list;
    // }

    @RequestMapping("/updateTracker")
    public void updateMovieTracker(@RequestBody MovieTracker movieTracker) {
        movieTrackerRepository.updateMyMovieTracker(movieTracker);
    }
}