import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Login } from './login/Login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  url: string = "http://localhost:8080/testBackEnd-1.0-SNAPSHOT/output";
  constructor(private http: HttpClient) { }
json: String;
httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
  getLogin(username, password): Observable<Login>{
    this.json =JSON.stringify({username: username, password: password});
    return this.http.post<Login>(this.url, this.json);
  }
}
