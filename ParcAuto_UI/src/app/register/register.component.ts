import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../_Services/common.service';
import { NgToastService } from 'ng-angular-popup';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
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
            this.clientService.setId(res.id.toString());
            this.clientService.setUsername(res.username);
            this.toast.success({
              detail: "Success",
              summary: "compte ajouté"
            });
            this.router.navigate(["/home"]);
          },error: err => {
            this.toast.error({
              detail: "Error",
              summary:err.error.message
            })
          }
        })
      }
      
    }else {
      this.toast.error({
        detail: "Error",
        summary: "Please fill all the fields"
      })
    }
  }
  goToLoginPage(){
    this.router.navigate(["/login"]);
  }
}
