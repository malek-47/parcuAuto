import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  constructor(private router:Router){}

  goToProfilePage(){
    this.router.navigate(["/profile"]);  
  }
  goToHomePage(){
    this.router.navigate(["/home"]);  
  }
  goToAddMissionPage(){
    this.router.navigate(["/missions/add"]);  
  }
  goToMissionPage(){
    this.router.navigate(["/missions"]);  
  }
  goToReportPage(){
    this.router.navigate(["/reports"]);  
  }
  goToAddReportPage(){
    this.router.navigate(["/reports/add"]);  
  }
}
