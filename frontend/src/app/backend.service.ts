import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'rejectUnauthorized': 'false',
  })
};


export interface eventsRequest {
  id?: string,
  start?: string,
  end?: string,
  title?: string
}

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private baseUrl = "api/public/v1/";

  constructor(private http: HttpClient) {
  }

  public getEventsForDate(date?: string) {
    return this
      .http
      .get<any>(this.baseUrl + "eventRequest?requestDate=" + date, httpOptions)
  }

}
