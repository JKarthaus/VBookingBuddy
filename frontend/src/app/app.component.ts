import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {EnquiryFormComponent} from "./enquiry-form/enquiry-form.component";
import {MAT_DATE_LOCALE} from "@angular/material/core";
import {NgbAccordionDirective, NgbAccordionModule, NgbAlert} from "@ng-bootstrap/ng-bootstrap";
import {ExtrasFormComponent} from "./extras-form/extras-form.component";
import {SummaryFormComponent} from "./summary-form/summary-form.component";

@Component(
  {
    selector: 'app-root',
    standalone: true,
    imports: [
      RouterOutlet,
      EnquiryFormComponent,
      NgbAccordionModule,
      NgbAlert,
      ExtrasFormComponent,
      SummaryFormComponent
    ],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    providers: [
      {provide: MAT_DATE_LOCALE, useValue: 'de-DE'}
    ]
  }
)
export class AppComponent implements AfterViewInit {
  @ViewChild('accMenue') accMenue!: NgbAccordionDirective;
  title = 'VBookingBuddy &#9400; by JK';

  ngAfterViewInit() {
  }

}
