import { Component, OnInit, Input } from '@angular/core';
import { TrackerService } from '../tracker.service';
import { FormGroup } from '@angular/forms';
import { MovieTracker } from './MovieTracker';
import { MoviedetailsService } from '../moviedetails.service';
import { ActivatedRoute, Router } from '@angular/router';
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
       private route: ActivatedRoute, private configService: ConfigService, private router: Router ) {
        // this.currentUser = this.tracker.currentUserValue;
   }
  @Input() 
  Tracked;
  Watched;
  movie;
  json;
  track = [];
  watch = [];

  // topRated;
  // Popular;

  ngOnInit() {
    // this.movie = this.route.snapshot.paramMap.get("movie");
    // 

    this.tracker.getTracked(sessionStorage.getItem("username")).subscribe(response => {
      this.Tracked = response;
      console.log(this.Tracked);

      for (var i=0; i<this.Tracked.length;i++){
        var obj = this.Tracked[i];
        // console.log(obj.movieid);
        
        // this.displayMovie(obj.movieid);
        this.details.getMovie(obj.movieid).subscribe((response) => { 
          this.movie = response;
          this.track.push(this.movie); 
        });
        }
        console.log(this.track);
      });
    
    
      

    this.tracker.getWatched(sessionStorage.getItem("username")).subscribe(response => {
      this.Watched = response;
      console.log(this.Watched);

      for (var i=0; i<this.Watched.length;i++){
        var obj = this.Watched[i];
        // console.log(obj.movieid);
        
        // this.displayMovie(obj.movieid);
        this.details.getMovie(obj.movieid).subscribe((response) => { 
          this.movie = response;
          this.watch.push(this.movie); 
        });
        }
        console.log(this.watch);
      });

  }

  logout(){
    sessionStorage.removeItem("username");
    this.router.navigate(["/login"]);
  }
  // remove(){
  //   this.json = {"id": }
  //   this.tracker.deleteTracker(json){

  //   }
  // }
}
