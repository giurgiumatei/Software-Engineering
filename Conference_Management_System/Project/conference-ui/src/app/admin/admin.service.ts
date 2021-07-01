import { Injectable } from '@angular/core';
import {Conference} from '../conference';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) { }

  public addConference(conference: Conference): any {
    return this.http.post(this.adminUrl + '/create-conference', conference);
  }

  public inviteChair(email: string): any {
    return this.http.post(this.adminUrl + '/invite', email);
  }
 }
