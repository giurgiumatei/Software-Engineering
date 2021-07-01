import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AdminService} from './admin.service';
import {Conference} from '../conference';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  createConferenceForm: FormGroup;
  inviteChairForm: FormGroup;

  constructor(private adminService: AdminService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.createConferenceForm = this.formBuilder.group({
      name: [''],
      startDate: [''],
      endDate: ['']
    });

    this.inviteChairForm = this.formBuilder.group({
      email: ['']
    });
  }

  createConference(): void {
    // tslint:disable-next-line:no-unused-expression
    const conference: Conference = this.createConferenceForm.value;
    console.log(conference);
    this.adminService.addConference(conference)
      .subscribe(() => alert('Conference added!'));
  }

  inviteChair(): void {
    const email: string = this.inviteChairForm.value;
    console.log(email);
    this.adminService.inviteChair(email)
      .subscribe(() => alert('Chair invited!'));
  }
}
