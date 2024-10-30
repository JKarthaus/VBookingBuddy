import {Component} from '@angular/core';
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
export class DiscountFormComponent {
  member: any;
  over25: any;

  constructor(protected backendService: BackendService) {
  }

}
