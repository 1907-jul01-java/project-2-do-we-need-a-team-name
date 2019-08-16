import { Component, Input, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { MoviedetailsService } from '../moviedetails.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ReviewsComponent } from '../reviews/reviews.component';
import { TrackerService } from '../tracker.service';
import { FormGroup } from '@angular/forms';
import { MovieTracker } from '../tracker/MovieTracker';

@Component({
  selector: 'app-moviedetails',
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.css']
})
export class MoviedetailsComponent implements OnInit {
  
  json;
  movieTracker: MovieTracker;
  @Input() movie;

  constructor(private config: ConfigService, private details: MoviedetailsService, 
    private route: ActivatedRoute, private tracker: TrackerService, private router: Router) { }

  ngOnInit() {
    this.movie = this.route.snapshot.paramMap.get("movie");
    this.displayMovie(this.movie);
  }

  displayMovie(id) {
    // Display movie from id
    this.details.getMovie(id).subscribe((response) => { this.movie = response; });
  }

  submitTracked() {
    // Add movie to tracked list
    this.json = {"username": sessionStorage.getItem("username"),
      "movieid": this.route.snapshot.paramMap.get("movie"),
      "tracked": true
   }
    this.tracker.postTracker(this.json).subscribe();
    this.router.navigate(['/user']);
  }

  submitWatched(){

    this.json = {"username": sessionStorage.getItem("username"),
      "movieid": this.route.snapshot.paramMap.get("movie"),
      "watched": true
   }
    this.tracker.postTracker(this.json).subscribe();
    this.router.navigate(['/user']);
  }


  // displayMovie(title) {
  //   this.details.getTitle(title).subscribe((response) => { this.movie = response; });
  // }

}
