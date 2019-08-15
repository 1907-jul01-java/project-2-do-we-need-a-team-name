import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from './config.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrackerService {
  url: string;

  constructor(private http: HttpClient) { }

  // getTracked(){
  //   this.url = ('https://api.themoviedb.org/3/movie/popular?api_key=' + this.ConfigService.getApiKey() + '&language=en-US&page=1');
  //   return this.http.get(this.url);
  // }

  // getWatched(){
  //   this.url = ('https://localhost:8080/getWatched?username={{username}}')
  // }

}
