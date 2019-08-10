import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, FormGroup} from '@angular/forms';
import { LoginServiceService } from '../login-service.service';
import { Login } from './Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  userInfo: Login;
  firstname;

  constructor(private formBuilder: FormBuilder, private loginService: LoginServiceService) {
  };

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  };

  get f() { return this.loginForm.controls; }

  OnSubmit(){
    console.log(this.loginService.getLogin(this.f.username.value, this.f.password.value).subscribe((data: Login) => this.userInfo = {...data}));
    this.firstname = this.userInfo.firstname;
  }
}
