import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Voiture } from 'src/app/_Models/voiture';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent {
  constructor(private router:Router, private reportService:CommonService, private toast: NgToastService){}

  @ViewChild('myForm') myForm?:NgForm;
  userId:number = +localStorage.getItem('id')!;

  reportRequest= {
    subject: "",
    description:"",
    dateAccident: "",
    lieuxAccident: "",
    voitureId: 0,
  } 
  addReport(){
    if(this.myForm?.valid){
     
      this.reportService.addReport(this.reportRequest,this.userId).subscribe({
        next: res => {
          this.toast.success({
            detail: "Success",
            summary: "Report a été ajouté"
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
    return this.reportService.getAllVoitures()
  }
  goToHomePage(){
    this.router.navigate(['home']);
  }

  ngOnInit() {
    this.voitureData$ =this.fetchVoitures();
  }
}
