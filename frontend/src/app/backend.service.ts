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
  phone?: string,
  partyBox?: boolean,
  lightCube?: boolean,
  cubeCount?: number,
  grill?: boolean
}


@Injectable({
  providedIn: 'root'
})
export class BackendService {
  get dateVerified(): boolean {
    return this._dateVerified;
  }

  set dateVerified(value: boolean) {
    this._dateVerified = value;
  }

  private baseUrl = "api/public/v1/";
  private _dateVerified: boolean = false;
  bookingRequest: bookingRequest = {}
  // -- Prices
  basePrice = 150;



  resetBookingRequest() {
    this.bookingRequest = {
      date: "",
      name: "",
      email: "",
      phone: "",
      partyBox: false,
      lightCube: false,
      cubeCount: 1,
      grill: true
    }
  }

  constructor(private http: HttpClient) {
    this.resetBookingRequest()
  }

  public getEventsForDate(date?: string) {
    return this
      .http
      .get<any>(this.baseUrl + "eventRequest?requestDate=" + date, httpOptions)
  }

  public sendEventRequest() {
    return this
      .http
      .post<any>(this.baseUrl + "storeEventRequest", this.bookingRequest, httpOptions)
  }

}
