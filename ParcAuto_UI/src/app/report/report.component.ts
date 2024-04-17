import { Component, OnInit } from '@angular/core';
import { Report } from '../_Models/report';
import { Observable } from 'rxjs';
import { CommonService } from '../_Services/common.service';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  constructor(private reportService:CommonService, private toast: NgToastService){}


  reports: Report[] = [];
  reportData$ = new Observable<Report[]>();
  description=""
  fetchReports():Observable<Report[]>{
    return this.reportService.getAllReports()
  }
  deleteReport(id:number){
    this.reportService.deleteReport(id).subscribe({
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
  showModel(modelName: string, description:string){
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
  ngOnInit() {
    this.reportData$ = this.fetchReports();
  }

}
