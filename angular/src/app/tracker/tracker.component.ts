import { Component, OnInit, Input } from '@angular/core';
import { TrackerService } from '../tracker.service';
import { FormGroup } from '@angular/forms';
import { MovieTracker } from './MovieTracker';
import { MoviedetailsService } from '../moviedetails.service';
import { ActivatedRoute } from '@angular/router';
import { Login } from '../login/Login';
import { ConfigService } from '../config.service';
import { stringify } from '@angular/core/src/util';

@Component({
  selector: 'app-tracker',
  templateUrl: './tracker.component.html',
  styleUrls: ['./tracker.component.css']
})
export class TrackerComponent implements OnInit {

  MovieForm: FormGroup;
  userInfo;
  movieTracker: MovieTracker;
  currentUser: Login;

  constructor(private tracker: TrackerService, private details: MoviedetailsService,
       private route: ActivatedRoute, private configService: ConfigService ) {
        // this.currentUser = this.tracker.currentUserValue;
   }
  @Input() 
  Tracked;
  Watched;
  movie;

  // topRated;
  // Popular;

  ngOnInit() {
    // this.movie = this.route.snapshot.paramMap.get("movie");
    // 

    this.tracker.getTracked("joshua").subscribe(response => {
      this.Tracked = response;
      console.log(this.Tracked)
      
      this.Tracked.forEach(
        function(obj) {
          this.displayMovie(this.obj.movieid);
        }
      ); 

      });
    
    
      

    // this.tracker.getWatched("joshua").subscribe(response => {
    //   this.Watched = response['results'];
    //   console.log(this.Watched);
    // });

    // this.tracker.postTracker(m ovieTracker).subscribe(response => {
    //   this.topRated = response['results'];
    //   console.log(this.topRated);
    // });
  }

  displayMovie(id) {
    this.details.getMovie(id).subscribe((response) => { this.movie = response; });
  }

}
