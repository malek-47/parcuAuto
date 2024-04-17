import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router:Router){}




  goToVoiturePage(){
    this.router.navigate(["/admin/voitures"]);  
  }
  goToClientPage(){
    this.router.navigate(["/admin/clients"]);  
  }
  goToMissionPage(){
    this.router.navigate(["/admin/missions"]);  
  }
  goToReportPage(){
    this.router.navigate(["/admin/reports"]);  
  }
  goToMaintenancePage(){
    this.router.navigate(["/admin/maintenances"]);  
  }
  goToDashboardPage(){
    this.router.navigate(["/admin/dashboard"]);  
  }
}
