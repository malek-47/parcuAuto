import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './Home/dashboard/dashboard.component';
import { VoitureComponent } from './voiture/voiture.component';
import { MissionComponent } from './mission/mission.component';
import { AddVoitureComponent } from './voiture/add-voiture/add-voiture.component';
import { ClientComponent } from './client/client.component';
import { AddClientComponent } from './client/add-client/add-client.component';
import { ReportComponent } from './report/report.component';
import { MaintenanceComponent } from './maintenance/maintenance.component';
import { AddMaintenanceComponent } from './maintenance/add-maintenance/add-maintenance.component';
import { UpdateVoitureComponent } from './voiture/update-voiture/update-voiture.component';
import { UpdateMaintenanceComponent } from './maintenance/update-maintenance/update-maintenance.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './Employe/home/home.component';
import { AddMissionComponent } from './Employe/add-mission/add-mission.component';
import { ProfileComponent } from './Employe/profile/profile.component';
import { AddReportComponent } from './Employe/add-report/add-report.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'admin/dashboard', component: DashboardComponent},
  { path: 'admin/voitures', component: VoitureComponent},
  { path: 'admin/voitures/add', component: AddVoitureComponent},
  { path: 'admin/voitures/update/:id', component: UpdateVoitureComponent},
  { path: 'admin/dashboard', component: DashboardComponent},
  { path: 'admin/clients', component: ClientComponent},
  { path: 'admin/clients/add', component: AddClientComponent},
  { path: 'admin/missions', component: MissionComponent},
  { path: 'admin/reports', component: ReportComponent},
  { path: 'admin/maintenances', component: MaintenanceComponent},
  { path: 'admin/maintenances/add', component: AddMaintenanceComponent},
  { path: 'admin/maintenances/update/:id', component: UpdateMaintenanceComponent},

  // employe
  { path: 'home', component: HomeComponent},
  { path: 'missions/add', component: AddMissionComponent},
  { path: 'reports/add', component: AddReportComponent},
  { path: 'profile', component: ProfileComponent},


];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
