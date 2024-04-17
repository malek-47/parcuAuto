import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Voiture } from '../_Models/voiture';
import { Observable } from 'rxjs';
import { CommonService } from '../_Services/common.service';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-voiture',
  templateUrl: './voiture.component.html',
  styleUrls: ['./voiture.component.css']
})


export class VoitureComponent implements OnInit {
  constructor(private router:Router, private voitureService:CommonService, private toast: NgToastService){}

  showModel(modelName: string){
    var model = document.getElementById(modelName);
    if (model){
      model.classList.add('show');
      model.style.display = 'block';
    }
  }
  closeModel(modelName: string){
    var model = document.getElementById(modelName);
  if (model) {
    model.classList.remove('show');
    model.style.display = 'none';
  }
  }
  goToAddVoiture(){
    this.router.navigate(['admin/voitures/add']);
  }
  goToUpdateVoiture(id:number){
    this.router.navigate([`admin/voitures/update/${id}`]);
  }
 
  voitures: Voiture[] = [];
  voitureData$ = new Observable<Voiture[]>();

  fetchVoitures():Observable<Voiture[]>{
    return this.voitureService.getAllVoitures()
  } 
  deleteVoiture(id:number){
    this.voitureService.deleteVoiture(id).subscribe({
      next: res => {
        
        this.toast.success({
          detail: "Success",
          summary: "Voiture a été supprimée"
        });
        this.fetchVoitures();
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
    
  }
  changeStatusToDispo(id:number){
    this.voitureService.changeToDispo(id).subscribe({
      next: res => {

        const voitureToUpdate = this.voitures.find(voiture => voiture.id === id);
        if (voitureToUpdate) {
          voitureToUpdate.statusVoiture = 'indisponible';
          
        }
        this.fetchVoitures();
      }, error: err =>  {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
    location.reload();
  }
  changeStatusToIndispo(id:number){
    this.voitureService.changeToIndispo(id).subscribe({
      next: res => {

        const voitureToUpdate = this.voitures.find(voiture => voiture.id === id );
      if (voitureToUpdate ) {
        voitureToUpdate.statusVoiture = 'disponible';
       
      }
      this.fetchVoitures();
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
    this.voitureData$ =this.fetchVoitures();
    // this.voitureData$.subscribe(voituresL => {
    //   this.voitures = voituresL;
    // });
  }



}
