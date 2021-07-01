import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Conference} from './conference';

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {
  private conferenceUrl = 'http://localhost:8080/chair';
  private currentConference: Conference = new Conference();

  constructor(private http: HttpClient) {
  }

  public setCurrentConference(conference: Conference): void{
    this.currentConference = conference;
  }

  public getCurrentConference(): Conference{
    return this.currentConference;
  }

  public getAllConferences(): Observable<Conference[]> {
    return this.http.get<Array<Conference>>(this.conferenceUrl);
  }

  public updateConference(conference: Conference): Observable<any>{
    const url = `${this.conferenceUrl}/updateConference/${conference.id}`;
    return this.http.put<Conference>(url, conference);
  }
}
