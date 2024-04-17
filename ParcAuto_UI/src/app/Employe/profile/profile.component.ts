import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Client } from 'src/app/_Models/client';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  constructor(private router:Router,private clientService:CommonService, private toast: NgToastService){}
  
  
  userId:number = +localStorage.getItem('id')!;
  username = localStorage.getItem('username')!;

  client= {} as Client ;
  clientData$ = new Observable<Client>();
  employeRequest = {
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    fonction: ""
  } 
  updateClient(){
    this.clientService.updateClient(this.userId, this.employeRequest).subscribe({
      next: res => {
        console.log(res)
        this.toast.success({
          detail: "Success",
          summary: "profile a été modifié"
        });
      
      },error: err => {
        this.toast.error({
          detail: "Error",
          summary:err.error.message
        })
      }
    })
  
}


  fetchClient():Observable<Client>{
    return this.clientService.getClient(this.userId)
  }

  ngOnInit(): void {
    this.clientData$ = this.fetchClient();
    this.clientData$.subscribe({
      next: res => {
        this.client = res
      }
    })
  }
}
