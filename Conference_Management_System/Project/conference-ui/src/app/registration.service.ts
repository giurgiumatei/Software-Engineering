import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { }

  public loginUser(user: User): any {
    console.log('User in service:', user);
    return this.http.post('http://localhost:8080/login', user);
  }

  public registerUser(user: User): Observable<any> {
    console.log('User in service:', user);
    const type = user.type;
    return this.http.post('http://localhost:8080/register/' + type, user);
  }
 }
