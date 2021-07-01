import { Component, OnInit } from '@angular/core';
import {Conference} from '../conference';
import {ConferenceService} from '../conference.service';

@Component({
  selector: 'app-listener',
  templateUrl: './listener.component.html',
  styleUrls: ['./listener.component.css']
})
export class ListenerComponent implements OnInit {

  conferences: Conference[];
  selectedConference: Conference;

  constructor(public conferenceService: ConferenceService) { }

  ngOnInit(): void {
    this.conferenceService.getAllConferences()
      .subscribe(conferences => this.conferences = conferences);
    console.log(this.conferences);
  }

  onSelect(conference: Conference): void {
    this.selectedConference = conference;
    alert(`Conference ${this.selectedConference.name} was selected`);
  }

}
