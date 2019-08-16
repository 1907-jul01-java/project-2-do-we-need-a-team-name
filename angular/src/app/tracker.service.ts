import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConfigService } from './config.service';
import { Observable } from 'rxjs';
import { MovieTracker } from './tracker/MovieTracker';
import { Login } from './login/Login';

@Injectable({
  providedIn: 'root'
})
export class TrackerService {
  url: string;
  public currentUser: Observable<Login>;

  constructor(private http: HttpClient) {
    // this.currentUser = this.current
   }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getTracked(username){
    this.url = (`http://localhost:8080/getTracked?username=${username}`);
    return this.http.get(this.url);
  }

  getWatched(username){
    this.url = (`http://localhost:8080/getWatched?username=${username}`);
    return this.http.get(this.url);
  }

  postTracker(json){
    this.url = (`http://localhost:8080/postTracker`)
    console.log(json);
    return this.http.post(this.url, json, this.httpOptions);
  }

  updateTracker(json){
    return this.http.put(this.url, json, this.httpOptions)
  }
}
