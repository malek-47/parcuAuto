import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../_Models/client';
import { CommonService } from '../_Services/common.service';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClientComponent implements OnInit {
  constructor(private router:Router,private clientService:CommonService, private toast: NgToastService){}

  clients: Client[] = [];
  clientData$ = new Observable<Client[]>();

  fetchClients():Observable<Client[]>{
    return this.clientService.getAllClients()
  }
  deleteClient(id:number){
    this.clientService.deleteClient(id).subscribe({
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
  goToAddClientPage(){
    this.router.navigate(['admin/clients/add']);
  }

  ngOnInit(): void {
    this.clientData$ = this.fetchClients();
  }

}
