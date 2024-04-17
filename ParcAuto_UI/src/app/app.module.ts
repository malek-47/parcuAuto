import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './Home/dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar/navbar.component';
import { TopbarComponent } from './navbar/topbar/topbar.component';
import { VoitureComponent } from './voiture/voiture.component';
import { DataTablesModule } from 'angular-datatables';
import { MissionComponent } from './mission/mission.component';
import { AddVoitureComponent } from './voiture/add-voiture/add-voiture.component';
import { ClientComponent } from './client/client.component';
import { AddClientComponent } from './client/add-client/add-client.component';
import { ReportComponent } from './report/report.component';
import { MaintenanceComponent } from './maintenance/maintenance.component';
import { AddMaintenanceComponent } from './maintenance/add-maintenance/add-maintenance.component';
import { DetailsMissionComponent } from './mission/details-mission/details-mission.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgToastModule } from 'ng-angular-popup';
import { UpdateVoitureComponent } from './voiture/update-voiture/update-voiture.component';
import { UpdateMaintenanceComponent } from './maintenance/update-maintenance/update-maintenance.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './Employe/home/home.component';
import { AddMissionComponent } from './Employe/add-mission/add-mission.component';
import { ProfileComponent } from './Employe/profile/profile.component';
import { AddReportComponent } from './Employe/add-report/add-report.component';
import { SidebarComponent } from './Employe/navbar/sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavbarComponent,
    SidebarComponent,
    TopbarComponent,
    VoitureComponent,
    MissionComponent,
    AddVoitureComponent,
    ClientComponent,
    AddClientComponent,
    ReportComponent,
    MaintenanceComponent,
    AddMaintenanceComponent,
    DetailsMissionComponent,
    UpdateVoitureComponent,
    UpdateMaintenanceComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AddMissionComponent,
    ProfileComponent,
    AddReportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DataTablesModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    NgToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
