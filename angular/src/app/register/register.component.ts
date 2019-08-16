import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Login } from '../login/Login';
import { RouterModule, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  userInfo: Login;
  loginInfo: Login;
  constructor(private formBuilder: FormBuilder, private registerService: RegisterService, private RouterModule: RouterModule, private router: Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  };

  get f() { return this.registerForm.controls; }

  OnSubmit() {
    this.registerService.postLogin({ 'username': this.f.username.value, 'password': this.f.password.value, 'guestid': null })
      .pipe(first())
      .subscribe(
        response => {
          sessionStorage.setItem('username', response.username);
          sessionStorage.setItem('guest_session_id', response.guestid);
          this.router.navigate(['']);
        });

  }
}
