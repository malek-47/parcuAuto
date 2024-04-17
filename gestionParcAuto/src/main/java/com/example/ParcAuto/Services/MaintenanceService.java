package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.MaintnenaceRequest;
import com.example.ParcAuto.DTOs.Requests.PortRequest;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Maintenance;
import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.MaintenanceRepository;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private VoitureRepository voitureRepository;

    public Maintenance addMaintenance(MaintnenaceRequest request){
        Voiture voiture = voitureRepository.findById(request.getVoitureId()).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        Maintenance maintenance = Maintenance.builder()
                .voiture(voiture)
                .type(request.getType())
                .duree(request.getDuree())
                .build();
        voiture.setStatusVoiture(StatusVoiture.indisponible);
        voitureRepository.save(voiture);
        return maintenanceRepository.save(maintenance);
    }
    public List<Maintenance> getLesMaintenances(){
        return maintenanceRepository.findAll();
    }

    public Maintenance getMaintenance(Long maintenanceId){
        return maintenanceRepository.findById(maintenanceId).orElseThrow(()-> new ObjectNotFoundException("maintenance not found"));
    }

    public Maintenance updateMaintenance(Long maintenanceId, MaintnenaceRequest maintenanceRequest){
        Maintenance savedMaintenance = maintenanceRepository.findById(maintenanceId).orElseThrow(()-> new ObjectNotFoundException("maintenance not found"));
        savedMaintenance.setType(maintenanceRequest.getType());
        savedMaintenance.setDuree(maintenanceRequest.getDuree());
        return  maintenanceRepository.save(savedMaintenance);
    }
    public void deleteMaintenance(Long maintenanceId){
        Maintenance maintenance = maintenanceRepository.findById(maintenanceId).orElseThrow(()-> new ObjectNotFoundException("maintenance not found"));
        Voiture voiture = maintenance.getVoiture();
        voiture.setStatusVoiture(StatusVoiture.disponible);
        voitureRepository.save(voiture);
        maintenanceRepository.delete(maintenance);

    }
}
