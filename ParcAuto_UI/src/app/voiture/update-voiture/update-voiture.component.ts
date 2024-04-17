import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Observable } from 'rxjs';
import { Voiture } from 'src/app/_Models/voiture';
import { CommonService } from 'src/app/_Services/common.service';

@Component({
  selector: 'app-update-voiture',
  templateUrl: './update-voiture.component.html',
  styleUrls: ['./update-voiture.component.css']
})
export class UpdateVoitureComponent implements OnInit {
  constructor(private router:Router,private route: ActivatedRoute, private voitureService:CommonService, private toast: NgToastService){
  }

  voitureId: number = this.route.snapshot.params['id'];
  voiture= {} as Voiture;
  voitureData$ = new Observable<Voiture>();


  fetchVoiture():Observable<Voiture>{
    return this.voitureService.getVoiture(this.voitureId)
  }
  updateVoiture(){
    
      this.voitureService.updateVoiture(this.voitureId, this.voiture).subscribe({
        next: res => {
          console.log(res)
          this.toast.success({
            detail: "Success",
            summary: "Voiture a été modifié"
          });
          this.goToVoiturePage()
        },error: err => {
          this.toast.error({
            detail: "Error",
            summary:err.error.message
          })
        }
      })
    
  }
  goToVoiturePage(){
    this.router.navigate(['admin/voitures']);
  }
  ngOnInit() {
    this.voitureData$ = this.fetchVoiture()
    this.voitureData$.subscribe({
      next: res => {
        this.voiture = res
      }
    })
  }
}
