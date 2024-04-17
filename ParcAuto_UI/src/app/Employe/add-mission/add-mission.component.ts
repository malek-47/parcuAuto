import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Voiture } from 'src/app/_Models/voiture';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-add-mission',
  templateUrl: './add-mission.component.html',
  styleUrls: ['./add-mission.component.css']
})
export class AddMissionComponent {
  constructor(private router:Router, private missionService:CommonService, private toast: NgToastService){}

  @ViewChild('myForm') myForm?:NgForm;
  username = localStorage.getItem('username')!;
  userId:number = +localStorage.getItem('id')!;
  passenger1 =""
  passenger2 = ""
  passenger3 = ""

  missionRequest= {
    dateDebut: "",
    dateFin:"",
    locationDebut: "",
    locationFin: "",
    companions: [] as string[],
    conducteur: "",
    voitureId: 0,
  } 

  addMission(){
    if(this.myForm?.valid){
      this.missionRequest.conducteur = this.username;
      this.missionRequest.companions.push(this.passenger1);
      this.missionRequest.companions.push(this.passenger2);
      this.missionRequest.companions.push(this.passenger3);
      this.missionService.addMission(this.missionRequest,this.userId).subscribe({
        next: res => {
          this.toast.success({
            detail: "Success",
            summary: "Voiture a été ajouté"
          });
          this.goToHomePage();
        },error: err => {
          this.toast.error({
            detail: "Error",
            summary:err.error.message
          })
        }
      })
    } else {
      this.toast.error({
        detail: "Error",
        summary:"please fill requiered fields"
      })
    }
  }
  voitures: Voiture[] = [];
  voitureData$ = new Observable<Voiture[]>();

  fetchVoitures():Observable<Voiture[]>{
    return this.missionService.getVoituresDispo()
  }
  goToHomePage(){
    this.router.navigate(['home']);
  }

  ngOnInit() {
    this.voitureData$ =this.fetchVoitures();
  }
}
