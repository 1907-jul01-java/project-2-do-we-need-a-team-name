import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, FormGroup} from '@angular/forms';
import { LoginServiceService } from '../login-service.service';
import { Login } from './Login';
import { Observable} from 'rxjs';
import {map} from 'rxjs/operators'
import { RouterModule, Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  userInfo;
  loginInfo: Login;

  constructor(private formBuilder: FormBuilder, private loginService: LoginServiceService, private RouterModule: RouterModule, private router: Router) {
  };

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  };

  get f() { return this.loginForm.controls; }

  OnSubmit(){
    // this.userInfo = this.loginService.getLogin(this.f.username.value, this.f.password.value);
    // this.loginInfo.username = this.f.username.value;
    // this.loginInfo.password = this.f.password.value;
    //this. userInfo = this.loginService.getLogin();
    console.log(this.f.username.value);
    this.loginInfo.username = this.f.username.value;
    this.loginInfo.password = this.f.password.value;
    this.loginService.postLogin(this.loginInfo).pipe(map(response => {
      this.userInfo = response;
      sessionStorage.setItem("username", this.userInfo.username);
      sessionStorage.setItem("guestId", this.userInfo.guestid);
    console.log(this.userInfo)}
    )).subscribe(data => {
      this.router.navigate(['home']);
    });
  }
}
