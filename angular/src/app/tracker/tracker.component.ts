import { Component, OnInit, Input } from '@angular/core';
import { TrackerService } from '../tracker.service';
import { FormGroup } from '@angular/forms';
import { MovieTracker } from './MovieTracker';
import { MoviedetailsService } from '../moviedetails.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-tracker',
  templateUrl: './tracker.component.html',
  styleUrls: ['./tracker.component.css']
})
export class TrackerComponent implements OnInit {

  MovieForm: FormGroup;
  userInfo;
  movieTracker: MovieTracker;

  constructor(private tracker: TrackerService, private details: MoviedetailsService, private route: ActivatedRoute) { }
  @Input() Tracked;
  Watched;
  movie;
  // topRated;
  // Popular;

  ngOnInit() {
    this.movie = this.route.snapshot.paramMap.get("movie");
    this.displayMovie(this.movie);

    this.tracker.getTracked(this.movieTracker.username).subscribe(response => {
      this.Tracked = response['results'];
      console.log(this.Tracked)
      });
    this.tracker.getWatched(this.movieTracker.username).subscribe(response => {
      this.Watched = response['results'];
      console.log(this.Watched);
    });
    // this.HomeService.getTopRated().subscribe(response => {
    //   this.topRated = response['results'];
    //   console.log(this.topRated);
    // });
  }

  displayMovie(id) {
    this.details.getMovie(id).subscribe((response) => { this.movie = response; });
  }

}
