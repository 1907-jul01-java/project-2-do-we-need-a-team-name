import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConfigService } from './config.service';
import { Observable } from 'rxjs';
import { MovieTracker } from './tracker/MovieTracker';

@Injectable({
  providedIn: 'root'
})
export class TrackerService {
  url: string;

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getTracked(username){
    this.url = (`https://localhost:8080/MovieTracker/getTracked?username=${username}`);
    return this.http.get(this.url);
  }

  getWatched(username){
    this.url = (`https://localhost:8080/MovieTracker/getWatched?username=${username}`);
    return this.http.get(this.url);
  }

  postTracker(movieTracker: MovieTracker){
    return this.http.post<MovieTracker[]>(this.url, MovieTracker, this.httpOptions);
  }

  updateTracker(movieTracker){

  }

