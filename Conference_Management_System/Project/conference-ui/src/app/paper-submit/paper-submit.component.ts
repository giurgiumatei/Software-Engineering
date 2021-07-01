import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PaperSubmitService} from '../paper-submit.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Paper} from '../paper';
import {Conference} from '../conference';
import {ConferenceService} from '../conference.service';


@Component({
  selector: 'app-paper-submit',
  templateUrl: './paper-submit.component.html',
  styleUrls: ['./paper-submit.component.css']
})
export class PaperSubmitComponent implements OnInit {
  conferences: Conference[];
  selectedConference: Conference;

  submitForm: FormGroup;
  public authorId: string;

  constructor(private paperSubmitService: PaperSubmitService,
              private conferenceService: ConferenceService,
              private formBuilder: FormBuilder,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.authorId = this.route.snapshot.paramMap.get('id');
    this.submitForm = this.formBuilder.group({
      title: [''],
      content: [''],
      authorId: this.authorId
    });

    this.conferenceService.getAllConferences()
      .subscribe(data => this.conferences = data);
  }

  onSubmit(): void {
    this.paperSubmitService.submitPaper(
      new Paper(
        this.submitForm.get('title').value,
        this.submitForm.get('content').value,
        this.submitForm.get('authorId').value,
      ),
      this.selectedConference.id
    )
      .subscribe(data => {
          console.log('response received');
        },
        error => console.log('exception'));

    this.router.navigate(['/submit/' + this.authorId]);
      /*.then(
        () => window.location.reload()
      );*/
  }
}
