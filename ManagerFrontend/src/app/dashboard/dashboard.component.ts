import {Component, inject} from '@angular/core';
import {AuthGoogleService} from "../services/auth-google.service";
import {Router} from "@angular/router";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    JsonPipe
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  private authService = inject(AuthGoogleService);
  private router = inject(Router);
  profile: any;

  ngOnInit(): void {
    this.showData();

  }

  showData() {
    this.profile = this.authService.getProfile();
    console.log(this.profile);
  }

  logOut() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }


}
