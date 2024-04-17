package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.MissionRequest;
import com.example.ParcAuto.Enum.StatusMission;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Consommation;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Models.OrdreMission;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.OrdreMissionRepository;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdreMissionService {
    @Autowired
    private OrdreMissionRepository ordreMissionRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private VoitureRepository voitureRepository;

    public OrdreMission getOrdreMission(Long missionId){
        return ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));
    }

    public List<OrdreMission> getAllMissions(){
        return ordreMissionRepository.findAll();
    }

    public List<OrdreMission> getMissionsByEmployeId(Long employeId){
        return ordreMissionRepository.findByEmployeId(employeId);
    }
    public List<OrdreMission> getMissionsByVoitureId(Long voitureId){
        return ordreMissionRepository.findByVoitureId(voitureId);
    }

    public OrdreMission addMission(Long employeId, MissionRequest request){
        Employe employe = employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found"));
        Voiture voiture = voitureRepository.findById(request.getVoitureId()).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        if (voiture.getStatusVoiture()==StatusVoiture.indisponible)
            throw new ObjectNotFoundException("voiture n'est pas diponible");
        OrdreMission ordreMission = OrdreMission.builder()
                .locationDebut(request.getLocationDebut())
                .locationFin(request.getLocationFin())
                .dateDebut(request.getDateDebut())
                .dateFin(request.getDateFin())
                .compagnons(request.getCompanions())
                .statusMission(StatusMission.Encours)
                .employe(employe)
                .conducteur(employe.getFirstName()+" "+employe.getLastName())
                .voiture(voiture)
                .build();
        voiture.setStatusVoiture(StatusVoiture.indisponible);
        voitureRepository.save(voiture);
        return ordreMissionRepository.save(ordreMission);
    }

    public OrdreMission updateMission(Long missionId, MissionRequest request){
        OrdreMission ordreMission = ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));

        ordreMission.setDateDebut(request.getDateDebut());
        ordreMission.setDateFin(request.getDateFin());
        ordreMission.setLocationDebut(request.getLocationDebut());
        ordreMission.setLocationFin(request.getLocationFin());
        ordreMission.setCompagnons(request.getCompanions());

        if (ordreMission.getStatusMission().equals(StatusMission.Validé) && request.getConsommation()!=null)
            ordreMission.setConsommation(request.getConsommation());
        else
            throw new RuntimeException("Mission doit etre validé avant de soumettre consommation");

        return ordreMissionRepository.save(ordreMission);
    }

    public OrdreMission changeMissionStatus(Long missionId, String status){
        OrdreMission ordreMission = ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));

        if (status == "ok"){
            ordreMission.setStatusMission(StatusMission.Validé);
        }
        else if (status == "ko"){
            ordreMission.setStatusMission(StatusMission.Annulé);
            Voiture voiture = ordreMission.getVoiture();
            voiture.setStatusVoiture(StatusVoiture.disponible);
            voitureRepository.save(voiture);
        }

        return ordreMissionRepository.save(ordreMission);
    }

    public OrdreMission ajoutConsommation(Long missionId, Consommation consommation){
        OrdreMission ordreMission = ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));
        ordreMission.setConsommation(consommation);
        return ordreMissionRepository.save(ordreMission);
    }
    public void deleteMission(Long missionId){
        OrdreMission ordreMission = ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));
        Voiture voiture = voitureRepository.findById(ordreMission.getVoiture().getId()).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        voiture.setStatusVoiture(StatusVoiture.disponible);
        voitureRepository.save(voiture);
        ordreMissionRepository.delete(ordreMission);
    }
}
