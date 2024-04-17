import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../_Services/common.service';
import { NgToastService } from 'ng-angular-popup';
import { Maintenance } from '../_Models/maintenance';
import { Observable } from 'rxjs';
import { Voiture } from '../_Models/voiture';

@Component({
  selector: 'app-maintenance',
  templateUrl: './maintenance.component.html',
  styleUrls: ['./maintenance.component.css']
})
export class MaintenanceComponent implements OnInit {
  constructor(private maintenanceService:CommonService, private toast: NgToastService, private router:Router){}



  maintenances: Maintenance[] = [];
  maintenanceData$ = new Observable<Maintenance[]>();
  
  fetchMaintenances():Observable<Maintenance[]>{
    return this.maintenanceService.getAllMaintenances()
  }
  
  deleteMaintenance(id:number){
    this.maintenanceService.deleteMaintenance(id).subscribe({
      next: res => {
        
        location.reload();
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
    
    
  }

  goToAddMaintenance(){
    this.router.navigate(['admin/maintenances/add']);
  }
  goToUpdateMaintenance(id:number){
    this.router.navigate([`admin/maintenances/update/${id}`]);
  }
  ngOnInit(): void {
    this.maintenanceData$ = this.fetchMaintenances();
  }
}
