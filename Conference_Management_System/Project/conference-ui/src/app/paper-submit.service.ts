import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Paper} from './paper';
import {ConferenceService} from './conference.service';
import {Conference} from './conference';

@Injectable({
  providedIn: 'root'
})
export class PaperSubmitService {

  constructor(private http: HttpClient,
              private conferenceService: ConferenceService) {
  }

  public submitPaper(paper: Paper, conferenceId: number): any {
    alert('Paper submited!');
    console.log(paper);

    // TODO maybe make a dropdown, but functionality should be the same

    return this.http.post(`http://localhost:8080/submit-paper/${paper.authorId}`, {
      paper,
      conferenceId
    });
  }
}
