import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HomeServiceService } from '../home-service.service';
import { ConfigService } from '../config.service';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { MovieInfo } from './MovieInfo';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private HomeService: HomeServiceService, private ConfigService: ConfigService) { }
  @Input() nowPlaying;
  nowPlayingDisplay;
  topRated;
  Popular;

  ngOnInit() {
    // this.nowPlaying = this.HomeService.getNowPlaying();
    // console.log(this.nowPlaying);
    // this.nowPlaying.imageURL = (this.ConfigService.getListImage() + this.nowPlaying.poster_path);
    // this.HomeService.getNowPlaying().pipe(map( response => {
    //   this.nowPlaying = response;
    //   this.nowPlaying.imageURL = (this.ConfigService.getListImage() + this.nowPlaying.results.poster_path);
    //   console.log(this.nowPlaying.results);
    // })).subscribe();
    this.HomeService.getNowPlaying().subscribe(response => {
      this.nowPlaying = response['results'];
      this.nowPlaying.forEach(function() {
        this.nowPlaying.imageURL = (this.ConfigService.getListImage() + this.nowPlaying['poster_path']);
      });
      
      console.log(this.nowPlaying)
      });
    this.topRated = this.HomeService.getTopRated();
    this.Popular = this.HomeService.getPopular();
  }

}
