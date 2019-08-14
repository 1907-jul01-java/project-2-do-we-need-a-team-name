package com.revature.controllers;

import java.util.ArrayList;

import com.revature.data.MovieTracker;
import com.revature.repositories.MovieTrackerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("MovieTracker")
public class MovieTrackerController {
    @Autowired
    private MovieTrackerRepo MovieTrackerRepository;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getTracker")
    public ArrayList<MovieTracker> getMovieTracker(@RequestParam(name = "username") String username){
        ArrayList<MovieTracker> list;
        list = (ArrayList<MovieTracker>) MovieTrackerRepository.listAllFromUsername(username);
        return list;
    }

    //Post method for adding a new MovieTracker given 
    @PostMapping("/postTracker")
    public ArrayList<MovieTracker> postMovieTracker(@RequestBody MovieTracker movieTracker){
        ArrayList<MovieTracker> list = new ArrayList<MovieTracker>();
        list.add(MovieTrackerRepository.postMovie(movieTracker));
        return list;
    }

    // @PutMapping("/updateTracker")
    // public MovieTracker returnMovieTracker(@RequestBody MovieTracker movieTracker) {
    //     list.add(MovieTrackerRepository.updateMyMovieTracker(movieTracker));
    //     return list;
    // }


}