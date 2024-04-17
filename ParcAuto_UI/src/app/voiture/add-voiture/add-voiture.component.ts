import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Voiture } from 'src/app/_Models/voiture';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-add-voiture',
  templateUrl: './add-voiture.component.html',
  styleUrls: ['./add-voiture.component.css']
})
export class AddVoitureComponent {
  constructor(private router:Router, private voitureService:CommonService, private toast: NgToastService){}

  voitureRequest= {
    marque: "",
    model:"",
    numMatricule: "",
    portName: "",
    numChassis: "",
    carburant: "",
    compteurKm: 0,
    prochainVidange: 0,
    countAccident: "",
    assurance:"",
    visiteTechnique: "",
    carteGrise: "",
    vignette: ""
  } 

  addVoiture(myForm:NgForm){
    if(myForm.valid){
      this.voitureService.addVoiture(this.voitureRequest).subscribe({
        next: res => {
          this.toast.success({
            detail: "Success",
            summary: "Voiture a été ajouté"
          });
          this.goToVoiturePage();
        },error: err => {
          this.toast.error({
            detail: "Error",
            summary:err.error.message
          })
        }
      })
    }
  }
  goToVoiturePage(){
    this.router.navigate(['admin/voitures']);
  }
}
