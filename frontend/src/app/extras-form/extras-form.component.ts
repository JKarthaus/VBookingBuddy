import {Component} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule} from "@angular/forms";
import {MatCheckbox} from "@angular/material/checkbox";

@Component({
  selector: 'app-extras-form',
  standalone: true,
  imports: [
    MatCardModule,
    MatButtonModule,
    FormsModule,
    MatCheckbox
  ],
  templateUrl: './extras-form.component.html',
  styleUrl: './extras-form.component.css'
})

export class ExtrasFormComponent {
  musicBox: any;
  lightCube: any;
  grill: any;

}
