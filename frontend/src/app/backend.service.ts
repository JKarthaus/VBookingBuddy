import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";

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
  grill?: boolean,
  gveMember?: boolean,
  agedGuests?: boolean
}

export interface priceList {
  basePrice?: number,
  partyBox?: number,
  lightCube?: number,
  grill?: number,
  discountMemberGVE?: number,
  discountAllCubes?: number,
  deposit?: number,
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
  priceList: priceList = {}

  resetBookingRequest() {
    this.bookingRequest = {
      date: "",
      name: "",
      email: "",
      phone: "",
      partyBox: false,
      lightCube: false,
      cubeCount: 1,
      grill: false,
      gveMember: false,
      agedGuests: false
    }
  }

  constructor(private http: HttpClient) {
    this.resetBookingRequest()
    this.getPriceList()
  }

  public getEventsForDate(date?: string) {
    return this
      .http
      .get<any>(this.baseUrl + "eventRequest?requestDate=" + date, httpOptions)
  }

  public sendEventRequest() {
    return this
      .http
      .post<any>(this.baseUrl + "storeReservationRequest", this.bookingRequest, httpOptions)
  }

  public calcPrice(): number {
    let result = this.priceList.basePrice ?? 0;
    result += this.priceList.deposit ?? 0;
    if (this.bookingRequest.grill) {
      result += this.priceList.grill ?? 0;
    }
    if (this.bookingRequest.lightCube) {
      result += (this.priceList.lightCube ?? 0) * (this.bookingRequest.cubeCount ?? 0);
    }
    if (this.bookingRequest.gveMember) {
      result -= this.priceList.discountMemberGVE ?? 0
    }
    if (this.bookingRequest.agedGuests) {
      result -= this.priceList.deposit ?? 0
    }
    return result;
  }

  public getPriceList() {
    return this
      .http
      .get<priceList>(this.baseUrl + "/priceList", httpOptions)
      .subscribe(
        {
          next: (priceList) => {
            console.log("get PriceList from Server")
            this.priceList = priceList
          },
          error: (e: HttpErrorResponse) => {
            console.error(e.message)
          },
          complete: () => console.info('complete')
        }
      )
  }

}
