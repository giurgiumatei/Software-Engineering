import {Component, OnInit} from '@angular/core';
import {ChairService} from '../chair.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {Section} from '../../section';

@Component({
  selector: 'app-section-new',
  templateUrl: './section-new.component.html',
  styleUrls: ['./section-new.component.css']
})
export class SectionNewComponent implements OnInit {

  constructor(private chairService: ChairService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
  }

  goBack(): void {
    this.location.back();
  }

  saveSection(numberOfParticipantsString: string, name: string, startTimeString: string, endTimeString: string): any {
    console.log(numberOfParticipantsString);
    const numberOfParticipants: number = +numberOfParticipantsString;
    console.log(numberOfParticipants);
    const startTime: number[] = startTimeString.split('-').map(x => +x);
    const endTime: number[] = endTimeString.split('-').map(x => +x);
    const section: Section = {numberOfParticipants , name, startTime, endTime} as Section;
    console.log(section);

    this.chairService.createSection(section)
      //.subscribe(_ => this.goBack());
      .subscribe(alert('Section added'));
  }

}
