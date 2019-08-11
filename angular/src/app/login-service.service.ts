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
json;
httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
  postLogin(login: Login): Observable<Login[]>{
    //  this.json =JSON.stringify({username: username, password: password});
    return this.http.post<Login[]>(this.url, login, this.httpOptions);
  }
  getLogin(): Observable<Login[]> {
    return this.http.get<Login[]>(this.url);
  }
}
