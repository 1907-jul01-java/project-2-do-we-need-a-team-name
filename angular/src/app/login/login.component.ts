import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { LoginServiceService } from '../login-service.service';
import { Login } from './Login';
import { Observable } from 'rxjs';
import { map, first } from 'rxjs/operators'
import { RouterModule, Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  userInfo: Login;
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

  OnSubmit() {
    this.loginService.postLogin({ 'username': this.f.username.value, 'password': this.f.password.value })
      .pipe(first())
      .subscribe(
        response => {
          sessionStorage.setItem('username', response.username)
          this.router.navigate(['/user']);
        });
    //this.loginService.postLogin()
    // this.userInfo = this.loginService.getLogin(this.f.username.value, this.f.password.value);
    // this.loginInfo.username = this.f.username.value;
    // this.loginInfo.password = this.f.password.value;
    //this. userInfo = this.loginService.getLogin();
    // this.loginInfo.username = this.f.username.value;
    // this.loginInfo.pw = this.f.pw.value;
    // console.log(this.loginInfo);
    // this.loginService.postLogin(this.loginInfo).pipe(map(response => {
    //   this.userInfo = response;
    //   sessionStorage.setItem("username", this.userInfo.username);
    //   sessionStorage.setItem("guestId", this.userInfo.guestid);
    // }
    // )).subscribe(data => {
    //   this.router.navigate(['home']);
    // });
  }
}
