package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.*;
import com.example.ParcAuto.Enum.StatusMission;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Models.Maintenance;
import com.example.ParcAuto.Models.Report;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.OrdreMissionRepository;
import com.example.ParcAuto.Repository.ReportRespository;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashService {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private ReportRespository reportRespository;
    @Autowired
    private OrdreMissionRepository missionRepository;

    public List<AlerteResponse> getAlerts(){
        List<Voiture> voitureIndispo = voitureRepository.findTop5VoituresIndispo();
        List<AlerteResponse> alerts = new ArrayList<>();
        for (Voiture voiture : voitureIndispo) {
            for (Maintenance maintenance : voiture.getMaintenanceList()){
                AlerteResponse alert = AlerteResponse.builder()
                        .voitureInfo(voiture.getMarque())
                        .voitureId(String.valueOf(voiture.getId()))
                        .alertType(maintenance.getType().toString())
                        .alertDate(maintenance.getDateMaintenance())
                        .build();
                alerts.add(alert);
            }
            for (Report report : voiture.getAccidentList()){
                AlerteResponse alert = AlerteResponse.builder()
                        .voitureInfo(voiture.getMarque())
                        .voitureId(String.valueOf(voiture.getId()))
                        .alertType("accident")
                        .alertDate(report.getDateAccident())
                        .build();
                alerts.add(alert);
            }
        }
        return alerts;
    }

    public DashboardResponse getDashData(){
        return DashboardResponse.builder()
                .numClient(employeRepository.count())
                .numMission(missionRepository.count())
                .numReport(reportRespository.count())
                .numVoiture(voitureRepository.count())
                .missionE(missionRepository.countByStatusMission(StatusMission.Encours))
                .missionA(missionRepository.countByStatusMission(StatusMission.Annulé))
                .missionV(missionRepository.countByStatusMission(StatusMission.Validé))
                .voitureDispo(voitureRepository.countByStatusVoiture(StatusVoiture.disponible))
                .voitureIndispo(voitureRepository.countByStatusVoiture(StatusVoiture.indisponible))
                .voitureParPort(voitureRepository.findVoituresByPort())
                .alerts(getAlerts())
                .build();

    }



}
