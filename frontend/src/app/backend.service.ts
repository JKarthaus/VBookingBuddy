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

export interface bookingRequest {
  date?: string,
  name?: string,
  email?: string,
  phone?: string
}


@Injectable({
  providedIn: 'root'
})
export class BackendService {
  get formOK(): boolean {
    return this._formOK;
  }

  set formOK(value: boolean) {
    this._formOK = value;
  }

  private baseUrl = "api/public/v1/";
  private _formOK: boolean = false;
  bookingRequest: bookingRequest = {
    email: "",
    phone: ""
  }

  constructor(private http: HttpClient) {
  }

  public getEventsForDate(date?: string) {
    return this
      .http
      .get<any>(this.baseUrl + "eventRequest?requestDate=" + date, httpOptions)
  }

}
