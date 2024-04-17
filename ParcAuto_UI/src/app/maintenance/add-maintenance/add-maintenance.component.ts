import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Voiture } from 'src/app/_Models/voiture';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-add-maintenance',
  templateUrl: './add-maintenance.component.html',
  styleUrls: ['./add-maintenance.component.css']
})
export class AddMaintenanceComponent implements OnInit {
  constructor(private router:Router, private maintenanceService:CommonService, private toast: NgToastService){}

  maintenanceRequest= {
    type: "",
    duree: "",
    dateMaintenance: "",
    frais: "",
    voitureId: 0
  }
  voitures: Voiture[] = [];
  voitureData$ = new Observable<Voiture[]>();
  
  fetchVoitures():Observable<Voiture[]>{
    return this.maintenanceService.getAllVoitures()
  }
  addMaintenance(myForm:NgForm){
    if(myForm.valid){
      this.maintenanceService.addMaintenance(this.maintenanceRequest).subscribe({
        next: res => {
          this.toast.success({
            detail: "Success",
            summary: "Maintenance a été ajouté"
          });
          this.goToMaintenancePage();
        },error: err => {
          this.toast.error({
            detail: "Error",
            summary:err.error.message
          })
        }
      })
    }
  }
  goToMaintenancePage(){
    this.router.navigate(['admin/maintenances']);
  }
  ngOnInit(): void {
    this.voitureData$ = this.fetchVoitures();
    this.voitureData$.subscribe({
      next: res => {
        this.voitures = res;
      }
    })
  }
}
