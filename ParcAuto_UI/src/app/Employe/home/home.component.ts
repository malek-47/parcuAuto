import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Consommation } from 'src/app/_Models/consommation';
import { Mission } from 'src/app/_Models/mission';
import { Report } from 'src/app/_Models/report';
import { Voiture } from 'src/app/_Models/voiture';
import { CommonService } from 'src/app/_Services/common.service';

@Component({ 
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private router:Router, private commonService:CommonService, private toast: NgToastService){}

  userId:number = +localStorage.getItem('id')!;

  consommation= {} as Consommation;

  missionDetails = {} as Mission;
  missionSelected = {} as Mission;
  showMissionModel(modelName: string, mission: Mission){
    var model = document.getElementById(modelName);
    if (model){
      model.classList.add('show');
      model.style.display = 'block';
      if (modelName =="consommationModal"){
        this.missionSelected = mission;
      }else 
        this.missionDetails = mission;
    }
  }

  showReportModel(modelName: string, description:string){
    var model = document.getElementById(modelName);
    if (model){
      model.classList.add('show');
      model.style.display = 'block';
      this.description = description
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
    return this.commonService.getMyMissions(this.userId)
  }
  deleteMission(id:number){
    this.commonService.deleteMission(id).subscribe({
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
  AjouterConsommation(){
    let id = this.missionSelected.id;
    this.missionSelected.consommation = this.consommation;
    console.log(this.missionSelected)
    this.commonService.updateMission(id,this.missionSelected).subscribe({
      next: res => {
        
        this.toast.success({
          detail: "Success",
          summary: "Consommation a été ajouté"
        });
        this.closeModel("consommationModal");
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
  
  }

  reports: Report[] = [];
  reportData$ = new Observable<Report[]>();
  description=""
  fetchReports():Observable<Report[]>{
    return this.commonService.getMyReports(this.userId)
  }
  deleteReport(id:number){
    this.commonService.deleteReport(id).subscribe({
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

  voitures: Voiture[] = [];
  voitureData$ = new Observable<Voiture[]>();

  fetchVoitures():Observable<Voiture[]>{
    return this.commonService.getVoituresDispo()
  }
  


  ngOnInit() {
    this.missionData$ =this.fetchMissions();
    this.reportData$ = this.fetchReports();
    this.voitureData$ =this.fetchVoitures();
  }
}
