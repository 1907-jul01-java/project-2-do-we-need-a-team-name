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
    console.log(sessionStorage.getItem("username"));
    this.HomeService.getNowPlaying().subscribe(response => {
      this.nowPlaying = response['results'];
      console.log(this.nowPlaying)
    });
    this.HomeService.getPopular().subscribe(response => {
      this.Popular = response['results'];
      console.log(this.Popular);
    });
    this.HomeService.getTopRated().subscribe(response => {
      this.topRated = response['results'];
      console.log(this.topRated);
    });
  }

}
