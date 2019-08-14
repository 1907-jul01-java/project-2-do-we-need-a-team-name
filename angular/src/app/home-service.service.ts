import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from './config.service';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {
  url: string;

  constructor(private http: HttpClient, private ConfigService: ConfigService) { }

  getPopular(){
    this.url = ('https://api.themoviedb.org/3/movie/popular?api_key=' + this.ConfigService.getApiKey() + '&language=en-US&page=1');
    return this.http.get(this.url);
  }

  getTopRated(){
    this.url = ('https://api.themoviedb.org/3/movie/top_rated?api_key=' + this.ConfigService.getApiKey() + '&language=en-US&page=1');
    return this.http.get(this.url);
  }

  getNowPlaying(){
    this.url = ('https://api.themoviedb.org/3/movie/now_playing?api_key=' + this.ConfigService.getApiKey() + '&language=en-US&page=1');
    return this.http.get(this.url);
  }
}
