import {Component} from '@angular/core';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerInputEvent, MatDatepickerModule} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";
import {MatSlideToggle} from "@angular/material/slide-toggle";
import {BackendService} from "../backend.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-enquiry-form',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, MatInputModule, MatDatepickerModule, MatSlideToggle],
  templateUrl: './enquiry-form.component.html',
  styleUrl: './enquiry-form.component.css'
})
export class EnquiryFormComponent {


  constructor(private backendService: BackendService) {
  }

  checkDate(event: MatDatepickerInputEvent<Date>) {
    this.backendService.getEventsForDate(event.value?.toDateString())
      .subscribe({
          next: (v) => {
            console.log("succeeded")
          },
          error: (e: HttpErrorResponse) => {
            console.error(e.message)

          },
          complete: () => console.info('complete')
        }
      )
  }
}
