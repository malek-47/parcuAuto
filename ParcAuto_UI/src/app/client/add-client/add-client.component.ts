import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Client } from 'src/app/_Models/client';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent {
  constructor(private router:Router, private clientService:CommonService, private toast: NgToastService){}
  employeRequest = {
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    fonction: ""
  } 
  confirmPassword = ""
  
  addClient(myForm:NgForm){
    if(myForm.valid){
      if(this.employeRequest.password !== this.confirmPassword){
        this.toast.error({
          detail: "Error",
          summary:"confirm password is incorrect"
        })
      } else {
        this.clientService.addClient(this.employeRequest).subscribe({
          next: res => {
            this.toast.success({
              detail: "Success",
              summary: "Client a été ajouté"
            });
            this.goToClientPage();
          },error: err => {
            this.toast.error({
              detail: "Error",
              summary:err.error.message
            })
          }
        })
      }
      
    }
  }

  goToClientPage(){
    this.router.navigate(['/admin/clients']);
  }
}
