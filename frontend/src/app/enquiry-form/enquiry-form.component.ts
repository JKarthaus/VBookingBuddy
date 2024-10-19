import {Component, OnDestroy} from '@angular/core';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerInputEvent, MatDatepickerModule} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";
import {MatSlideToggle} from "@angular/material/slide-toggle";
import {BackendService} from "../backend.service";
import {HttpErrorResponse} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-enquiry-form',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, MatInputModule, MatDatepickerModule, MatSlideToggle, FormsModule],
  templateUrl: './enquiry-form.component.html',
  styleUrl: './enquiry-form.component.css'
})

export class EnquiryFormComponent implements OnDestroy {
  eMail: string | undefined = " "
  phoneNumber: string | undefined = " "
  name: string | undefined = " "
  date: string | undefined = " "

  constructor(private backendService: BackendService) {
    this.eMail = backendService.bookingRequest.email;
    this.phoneNumber = backendService.bookingRequest.phone;
    this.name = backendService.bookingRequest.name;
    this.date = backendService.bookingRequest.date;
  }


  ngOnDestroy() {
    this.backendService.bookingRequest.email = this.eMail
    this.backendService.bookingRequest.phone = this.phoneNumber
    this.backendService.bookingRequest.name = this.name
    this.backendService.bookingRequest.date = this.date
  }

  checkDate(event: MatDatepickerInputEvent<Date>) {
    this.backendService.getEventsForDate(event.value?.toISOString())
      .subscribe({
          next: (v) => {
            console.log("succeeded")
            this.backendService.bookingRequest.date = event.value?.toISOString();
          },
          error: (e: HttpErrorResponse) => {
            console.error(e.message)
          },
          complete: () => console.info('complete')
        }
      )
  }
}
