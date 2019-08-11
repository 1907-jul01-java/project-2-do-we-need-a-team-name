import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, FormGroup} from '@angular/forms';
import { LoginServiceService } from '../login-service.service';
import { Login } from './Login';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  userInfo: Observable<Login[]>;
  loginInfo: Login;

  constructor(private formBuilder: FormBuilder, private loginService: LoginServiceService) {
  };

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.userInfo = this.loginService.getLogin();
  };

  get f() { return this.loginForm.controls; }

  OnSubmit(){
    // this.userInfo = this.loginService.getLogin(this.f.username.value, this.f.password.value);
    // this.loginInfo.username = this.f.username.value;
    // this.loginInfo.password = this.f.password.value;
    // this. userInfo = this.loginService.getLogin(this.loginInfo);
    this.userInfo = this.loginService.getLogin();
  }
}
