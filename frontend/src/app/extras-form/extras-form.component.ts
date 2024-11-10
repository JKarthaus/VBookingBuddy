import {Component, OnDestroy} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule} from "@angular/forms";
import {MatCheckbox} from "@angular/material/checkbox";
import {MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {BackendService} from "../backend.service";

@Component({
  selector: 'app-extras-form',
  standalone: true,
  imports: [
    MatCardModule,
    MatButtonModule,
    FormsModule,
    MatCheckbox,
    MatLabel,
    MatSelect,
    MatOption
  ],
  templateUrl: './extras-form.component.html',
  styleUrl: './extras-form.component.css'
})

export class ExtrasFormComponent {
  musicBox: boolean | undefined = false;
  lightCube: boolean | undefined = false;
  grill: boolean | undefined = false;
  cubeCount: number | undefined;

  constructor(private backendService: BackendService) {
    this.musicBox = backendService.bookingRequest.partyBox;
    this.lightCube = backendService.bookingRequest.lightCube;
    this.grill = backendService.bookingRequest.grill;
    this.cubeCount = backendService.bookingRequest.cubeCount;
  }

  changeForm(): void {
    this.backendService.bookingRequest.partyBox = this.musicBox;
    this.backendService.bookingRequest.lightCube = this.lightCube;
    this.backendService.bookingRequest.grill = this.grill;
    this.backendService.bookingRequest.cubeCount = this.cubeCount;
  }


}
