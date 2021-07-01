import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {RegistrationService} from '../registration.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private registrationService: RegistrationService,
              private formBuilder: FormBuilder,
              private router: Router) { }


  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      username: [''],
      email: [''],
      password: [''],
      type: [''],
    });
  }

  onSubmit(): void {
    this.registrationService.registerUser(this.registerForm.value)
      .subscribe(data => {
          console.log('response received');
        },
        error => console.log('exception'));
  }
}
