import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {FullCalendarModule} from "@fullcalendar/angular";
import {CalendarOptions} from "@fullcalendar/core";
import multiMonthPlugin from '@fullcalendar/multimonth';
import {EnquiryFormComponent} from "./enquiry-form/enquiry-form.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FullCalendarModule, EnquiryFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'VBookingBuddy';
  calendarOptions: CalendarOptions = {
    initialView: 'multiMonthYear',
    multiMonthMaxColumns: 1,
    plugins: [multiMonthPlugin]
  };
}
