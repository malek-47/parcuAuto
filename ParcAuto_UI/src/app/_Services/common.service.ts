import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../_Models/client';
import { Voiture } from '../_Models/voiture';
import { Maintenance } from '../_Models/maintenance';
import { Mission } from '../_Models/mission';
import { DashData } from '../_Models/dashData';
import { Report } from '../_Models/report';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  private baseUrl = 'http://localhost:8383';

  sharedData: string = ""

  constructor(
    private http: HttpClient,
  ) { }

 //login

  login(loginRequest:any): Observable<Client> {
    return this.http.post<Client>(`${this.baseUrl}/employes/login`,loginRequest);
  }
  register(registerRequest:any): Observable<Client> {
    return this.http.post<Client>(`${this.baseUrl}/employes`,registerRequest);
  }
  setId(id:string){
    localStorage.setItem('id',id);
  }
  setUsername(username:string){
    localStorage.setItem('username',username);
  }
  logout(){
    localStorage.clear();
  }

  //Mes services
  getMyReports(id:number): Observable<Report[]> {
    return this.http.get<Report[]>(`${this.baseUrl}/reports/employe/${id}`);
  }
  getMyMissions(id:number): Observable<Mission[]> {
    return this.http.get<Mission[]>(`${this.baseUrl}/missions/employe/${id}`);
  }

  // Get all 
  getAllClients(): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.baseUrl}/employes`);
  }
  getAllVoitures(): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${this.baseUrl}/voitures`);
  }
  getAllReports(): Observable<Report[]> {
    return this.http.get<Report[]>(`${this.baseUrl}/reports`);
  }
  getAllMaintenances(): Observable<Maintenance[]> {
    return this.http.get<Maintenance[]>(`${this.baseUrl}/maintenances`);
  }
  getAllMissions(): Observable<Mission[]> {
    return this.http.get<Mission[]>(`${this.baseUrl}/missions`);
  }

 

  // get Dashboard
  getDash(): Observable<DashData> {
    return this.http.get<DashData>(`${this.baseUrl}/dash`);
  }
 

  // dispo and not dispo
  changeToDispo(id:number): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/voitures/${id}/dispo`,{});
  }
  changeToIndispo(id:number): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/voitures/${id}/indispo`,{});
  }
  getVoituresDispo(): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${this.baseUrl}/voitures/dispo`,{});
  }


  // v or A
  changeToValid(id:number): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/missions/${id}/ok`,{});
  }
  changeToRefuse(id:number): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/missions/${id}/ko`,{});
  }

  // Ajouter

  addClient(createRequest:any): Observable<any> {
    return this.http.post(`${this.baseUrl}/employes`,createRequest);
  }
  addMaintenance(createRequest:any): Observable<any> {
    return this.http.post(`${this.baseUrl}/maintenances`,createRequest);
  }
  addVoiture(createRequest:any): Observable<any> {
    return this.http.post(`${this.baseUrl}/voitures`,createRequest);
  }
  addReport(createRequest:any,id:number): Observable<any> {
    return this.http.post(`${this.baseUrl}/reports/employe/${id}`,createRequest);
  }
  addMission(createRequest:any,id:number): Observable<any> {
    return this.http.post(`${this.baseUrl}/missions/employe/${id}`,createRequest);
  }

  //delete
  deleteClient(id:number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/employes/${id}`);
  }
  deleteMaintenance(id:number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/maintenances/${id}`);
  }
  deleteReport(id:number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/reports/${id}`);
  }
  deleteVoiture(id:number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/voitures/${id}`);
  }
  deleteMission(id:number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/missions/${id}`);
  }
   // Get by Id
   getClient(id:number): Observable<Client> {
    return this.http.get<Client>(`${this.baseUrl}/employes/${id}`);
  }
  getMaintenance(id:number): Observable<Maintenance> {
    return this.http.get<Maintenance>(`${this.baseUrl}/maintenances/${id}`);
  }
  getReport(id:number): Observable<Report> {
    return this.http.get<Report>(`${this.baseUrl}/reports/${id}`);
  }
  getVoiture(id:number): Observable<Voiture> {
    return this.http.get<Voiture>(`${this.baseUrl}/voitures/${id}`);
  }
  getMission(id:number): Observable<Mission> {
    return this.http.get<Mission>(`${this.baseUrl}/missions/${id}`);
  }

     // Update
     updateClient(id:number,createRequest:any): Observable<any> {
      return this.http.put(`${this.baseUrl}/employes/${id}`,createRequest);
    }
    updateMaintenance(id:number,createRequest:any): Observable<any> {
      return this.http.put(`${this.baseUrl}/maintenances/${id}`,createRequest);
    }
    updateReport(id:number, createRequest:any): Observable<any> {
      return this.http.put(`${this.baseUrl}/reports/${id}`,createRequest);
    }
    updateVoiture(id:number, createRequest:any): Observable<any> {
      return this.http.put(`${this.baseUrl}/voitures/${id}`, createRequest);
    }
    updateMission(id:number, createRequest:any): Observable<any> {
      return this.http.put(`${this.baseUrl}/missions/${id}`, createRequest);
    }
}
