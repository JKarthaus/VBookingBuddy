import {Component} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatCheckbox} from "@angular/material/checkbox";
import {FormsModule} from "@angular/forms";
import {BackendService} from "../backend.service";

@Component({
  selector: 'app-summary-form',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, MatCheckbox, FormsModule],
  templateUrl: './summary-form.component.html',
  styleUrl: './summary-form.component.css'
})
export class SummaryFormComponent {
  member: any;
  over25: any;

  constructor(private backendService: BackendService) {
    console.log("Email:" + backendService.bookingRequest.email)
  }

}
