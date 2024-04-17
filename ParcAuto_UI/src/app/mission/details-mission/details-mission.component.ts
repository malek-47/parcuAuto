import { Component, Input } from '@angular/core';
import { Mission } from 'src/app/_Models/mission';

@Component({
  selector: 'app-details-mission',
  templateUrl: './details-mission.component.html',
  styleUrls: ['./details-mission.component.css']
})
export class DetailsMissionComponent {

  @Input()
  mission!:Mission;


}
