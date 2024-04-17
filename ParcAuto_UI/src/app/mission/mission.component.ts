import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../_Services/common.service';
import { NgToastService } from 'ng-angular-popup';
import { Mission } from '../_Models/mission';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-mission',
  templateUrl: './mission.component.html',
  styleUrls: ['./mission.component.css']
})
export class MissionComponent {
  constructor(private router:Router, private missionService:CommonService, private toast: NgToastService){}

  missionDetails = {} as Mission;

  showModel(modelName: string, mission: Mission){
    var model = document.getElementById(modelName);
    if (model){
      model.classList.add('show');
      model.style.display = 'block';
      this.missionDetails = mission;
    }
  }
  closeModel(modelName: string){
    var model = document.getElementById(modelName);
  if (model) {
    model.classList.remove('show');
    model.style.display = 'none';
  }
  }
  missions: Mission[] = [];
  missionData$ = new Observable<Mission[]>();

  fetchMissions():Observable<Mission[]>{
    return this.missionService.getAllMissions()
  }
  deleteMission(id:number){
    this.missionService.deleteMission(id).subscribe({
      next: res => {
        
        this.toast.success({
          detail: "Success",
          summary: "Mission a été supprimée"
        });
        this.fetchMissions();
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
    location.reload();
    
  }
  changeStatusToValid(id:number){
    this.missionService.changeToValid(id).subscribe({
      next: res => {

        
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
    location.reload();
  }
  changeStatusToRefuse(id:number){
    this.missionService.changeToRefuse(id).subscribe({
      next: res => {

       
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
    location.reload();
  }



  ngOnInit() {
    this.missionData$ =this.fetchMissions();

  }
}
