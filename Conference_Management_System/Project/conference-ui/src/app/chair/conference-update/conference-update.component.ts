import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ConferenceService} from '../../conference.service';
import {FormBuilder} from '@angular/forms';
import {Conference} from '../../conference';

@Component({
  selector: 'app-conference-update',
  templateUrl: './conference-update.component.html',
  styleUrls: ['./conference-update.component.css']
})
export class ConferenceUpdateComponent implements OnInit {
  updateConferenceForm: any;
  currentConference: Conference = new Conference();

  constructor(private router: Router,
              private conferenceService: ConferenceService,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.currentConference = this.conferenceService.getCurrentConference();
    this.updateConferenceForm = this.formBuilder.group({
      name: [`${this.currentConference.name}`],
      startDate: [`${this.currentConference.startDate}`],
      endDate: [`${this.currentConference.endDate}`]
    });
  }


  updateConference(): void {
    this.currentConference.name = this.updateConferenceForm.value.name;
    this.currentConference.startDate = this.updateConferenceForm.value.startDate;
    this.currentConference.endDate = this.updateConferenceForm.value.endDate;

    this.conferenceService.updateConference(this.currentConference).subscribe(
      () => {
        alert('update done! ');
        this.router.navigate([`/chair`]);
      },
      error => {
        alert(`Error: ${error}`);
      }
    );
  }
}
