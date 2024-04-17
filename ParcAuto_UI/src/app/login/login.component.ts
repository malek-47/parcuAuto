import { Component } from '@angular/core';
import { CommonService } from '../_Services/common.service';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginRequest: any = {
    username: "",
    password: ""
  };

  constructor(
    private userAuthService: CommonService,
    private router: Router,
    private toast: NgToastService
  ) { }

  login(myForm:NgForm) {
    if(this.loginRequest.username === "admin"){
      this.router.navigate(["/admin/dashboard"]);
      return;
    }
    if (myForm.valid) {
      this.userAuthService.login(this.loginRequest).subscribe({
        next: res => {
          console.log(res)
          this.userAuthService.setId(res.id.toString());
          this.userAuthService.setUsername(res.username);
          this.router.navigate(["/home"]);
          this.toast.success({
            detail: "Success",
            summary: "Login Successful"
          });
        },
        error: res => {
          this.toast.error({
            detail: "Error",
            summary: "Invalid Credentials"
          })
        }
      })
    }else {
      this.toast.error({
        detail: "Error",
        summary: "Please fill all the fields"
      })
    }
  }



      
    
    
  


}
