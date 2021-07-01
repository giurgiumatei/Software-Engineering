import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Paper} from '../paper';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaperService {
  private papersUrl = 'http://localhost:8080/pcmember';

  constructor(private http: HttpClient) {
  }

  public getAllPapers(): Observable<Paper[]> {
    return this.http.get<Array<Paper>>(this.papersUrl);
  }
}
