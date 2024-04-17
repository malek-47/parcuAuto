import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DashData } from 'src/app/_Models/dashData';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private dashService:CommonService){}

  dashData= {} as DashData;
  dashData$ = new Observable<DashData>();

  fetchDashData():Observable<DashData>{
    return this.dashService.getDash()
  }

  ngOnInit() {
    this.dashData$ = this.fetchDashData();
  }



}
