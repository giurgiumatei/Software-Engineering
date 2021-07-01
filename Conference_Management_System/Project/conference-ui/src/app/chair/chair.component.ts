import { Component, OnInit } from '@angular/core';
import {Conference} from '../conference';
import {ConferenceService} from '../conference.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ChairService} from './chair.service';

@Component({
  selector: 'app-chair',
  templateUrl: './chair.component.html',
  styleUrls: ['./chair.component.css']
})
export class ChairComponent implements OnInit {

  conferences: Conference[];
  inviteForm: FormGroup;

  constructor(public conferenceService: ConferenceService,
              public chairService: ChairService,
              private router: Router,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.inviteForm = this.formBuilder.group({
      email: [''],
      memberType: ['']
    });
    this.conferenceService.getAllConferences()
      .subscribe(conferences => this.conferences = conferences);
    console.log(this.conferences);
  }

  updateConference(conference: Conference): void {
    this.conferenceService.setCurrentConference(conference);
    this.router.navigate(['/chair-update-conference']);
  }

  invite(): void {
    const value = this.inviteForm.value;
    console.log(value);
    this.chairService.inviteChair(value)
      .subscribe(data => console.log(data));

  }

  // addPaper(): void {
  //   this.router.navigate(['/submit', id]);
  // }
}
