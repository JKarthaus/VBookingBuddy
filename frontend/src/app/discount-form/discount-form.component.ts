import {Component, OnDestroy} from '@angular/core';
import {
  MatCard,
  MatCardActions,
  MatCardContent,
  MatCardHeader,
  MatCardSubtitle,
  MatCardTitle
} from "@angular/material/card";
import {MatCheckbox} from "@angular/material/checkbox";
import {BackendService} from "../backend.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-discount-form',
  standalone: true,
  imports: [
    MatCard,
    MatCardActions,
    MatCardHeader,
    MatCardSubtitle,
    MatCardTitle,
    MatCheckbox,
    FormsModule,
    MatCardContent
  ],
  templateUrl: './discount-form.component.html',
  styleUrl: './discount-form.component.css'
})
export class DiscountFormComponent implements OnDestroy {
  member: any;
  agedGuests: any;

  constructor(protected backendService: BackendService) {
    this.member = backendService.bookingRequest.gveMember;
    this.agedGuests = backendService.bookingRequest.agedGuests;

  }

  ngOnDestroy(): void {
    this.backendService.bookingRequest.gveMember = this.member;
    this.backendService.bookingRequest.agedGuests = this.agedGuests;
  }

}
