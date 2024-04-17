import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Maintenance } from 'src/app/_Models/maintenance';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-update-maintenance',
  templateUrl: './update-maintenance.component.html',
  styleUrls: ['./update-maintenance.component.css']
})
export class UpdateMaintenanceComponent implements OnInit{
  constructor(private router:Router,private route: ActivatedRoute, private maintenanceService:CommonService, private toast: NgToastService){
  }

  maintenanceId: number = this.route.snapshot.params['id'];
  maintenance= {} as Maintenance;
  maintenanceData$ = new Observable<Maintenance>();


  fetchMaintenance():Observable<Maintenance>{
    return this.maintenanceService.getMaintenance(this.maintenanceId)
  }
  updateMaintenance(){
    
      this.maintenanceService.updateMaintenance(this.maintenanceId, this.maintenance).subscribe({
        next: res => {
          console.log(res)
          this.toast.success({
            detail: "Success",
            summary: "Maintenance a été modifié"
          });
          this.goToMaintenancePage()
        },error: err => {
          this.toast.error({
            detail: "Error",
            summary:err.error.message
          })
        }
      })
    
  }
  goToMaintenancePage(){
    this.router.navigate(['admin/maintenances']);
  }
  ngOnInit() {
    this.maintenanceData$ = this.fetchMaintenance()
    this.maintenanceData$.subscribe({
      next: res => {
        this.maintenance = res
      }
    })
  }
}
