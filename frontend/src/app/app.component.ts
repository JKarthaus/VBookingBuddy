import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {EnquiryFormComponent} from "./enquiry-form/enquiry-form.component";
import {MAT_DATE_LOCALE} from "@angular/material/core";
import {NgbAccordionDirective, NgbAccordionModule, NgbAlert} from "@ng-bootstrap/ng-bootstrap";
import {ExtrasFormComponent} from "./extras-form/extras-form.component";
import {SummaryFormComponent} from "./summary-form/summary-form.component";
import {MatToolbar} from "@angular/material/toolbar";
import {MatIcon} from "@angular/material/icon";
import {MatDivider} from "@angular/material/divider";
import {BackendService} from "./backend.service";
import {MatDialogClose} from "@angular/material/dialog";
import {debounceTime, Subject, tap} from "rxjs";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {HttpErrorResponse} from "@angular/common/http";
import {DiscountFormComponent} from "./discount-form/discount-form.component";
import {MatButton} from "@angular/material/button";

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
      SummaryFormComponent,
      MatToolbar,
      MatIcon,
      MatDivider,
      MatDialogClose,
      DiscountFormComponent,
      MatButton
    ],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    providers: [
      {provide: MAT_DATE_LOCALE, useValue: 'de-DE'}
    ]
  }
)
export class AppComponent implements AfterViewInit {
  title = 'VBookingBuddy &#9400; by JK';

  private _formStateMessage$ = new Subject<string>();
  private _formSavedResponse$ = new Subject<string>();

  formStateMessage = '';
  showFormSavedInfo = false;

  @ViewChild('accMenue') accMenue!: NgbAccordionDirective;
  @ViewChild('selfClosingAlert', {static: false}) selfClosingAlert: NgbAlert | undefined;
  @ViewChild('formSavedInfo', {static: false}) formSavedInfo: NgbAlert | undefined;

  constructor(private backendService: BackendService) {
    this._formStateMessage$.pipe(
      takeUntilDestroyed(),
      tap((message) => (this.formStateMessage = message)),
      debounceTime(4000),
    ).subscribe(() => this.selfClosingAlert?.close());

    this._formSavedResponse$.pipe(
      takeUntilDestroyed(),
      debounceTime(4000),
    ).subscribe(() => this.formSavedInfo?.close());
  }

  checkAndSend() {
    this.accMenue.collapseAll()
    let message = "";
    if (this.backendService.bookingRequest.date?.length == 0) {
      message += "Datum fehlt.\r<br>"
    }
    if (!this.backendService.dateVerified) {
      message += "Datum nicht verfügbar.\r<br>"
    }
    if (this.backendService.bookingRequest.name?.trim().length == 0) {
      message += "Name fehlt.<br>"
    }
    if (this.backendService.bookingRequest.email?.trim().length == 0) {
      message += "Mail Adresse fehlt.<br>"
    }
    if (this.backendService.bookingRequest.phone?.trim().length == 0) {
      message += "Telefonnummer fehlt.<br>"
    }
    if (message.length > 0) {
      this._formStateMessage$.next(message)
    } else {
      this.backendService.sendEventRequest()
        .subscribe({
            next: (v) => {
              console.log("succeeded")
              this._formSavedResponse$.next("")
              this.showFormSavedInfo = true;
              this.backendService.resetBookingRequest();
            },
            error: (e: HttpErrorResponse) => {
              console.error(e.message)
            },
            complete: () => console.info('complete')
          }
        )
    }

  }

  ngAfterViewInit() {
  }

}
