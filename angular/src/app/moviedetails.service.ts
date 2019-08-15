import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from './config.service';

@Injectable({
  providedIn: 'root'
})
export class MoviedetailsService {
  url: string;

  constructor(private http: HttpClient, private config: ConfigService) { }

  getMovie(movieId) {
    this.url = (`https://api.themoviedb.org/3/movie/${movieId}?api_key=${this.config.getApiKey()}&language=en-US`);
    return this.http.get(this.url);
  }

  getTitle(title) {
    this.url = (`https://api.themoviedb.org/3/search/movie/?api_key=${this.config.getApiKey()}&language=en-US&query=${title}&page&page=1&include_adult=false`);
    return this.http.get(this.url);
  }

  getReviews(movieId){
    this.url = (`https://api.themoviedb.org/3/movie/${movieId}/reviews?api_key=${this.config.getApiKey()}&language=en-US&page=1`);
    return this.http.get(this.url);
  }

  postRating(movieId, guestId, rating){
    this.url = (`https://api.themoviedb.org/3/movie/${movieId}/rating?api_key=${this.config.getApiKey()}&guest_session_id=${guestId}`);
    return this.http.post(this.url, JSON.parse(`{ "value": ${rating}}`));
  }
}
