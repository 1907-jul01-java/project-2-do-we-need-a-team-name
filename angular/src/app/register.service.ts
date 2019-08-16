import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Login } from './login/Login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  url: string = "http://localhost:8080/register";
  constructor(private http: HttpClient) { }
  json;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  postLogin(login: Login): Observable<Login> {
    //  this.json =JSON.stringify({username: username, password: password});
    console.log(login);
    console.log(this.http.post<Login>(this.url, login, this.httpOptions));
    return this.http.post<Login>(this.url, JSON.stringify(login), this.httpOptions);
  }
  getLogin() {
    return this.http.get<Login>(this.url);
  }
}
