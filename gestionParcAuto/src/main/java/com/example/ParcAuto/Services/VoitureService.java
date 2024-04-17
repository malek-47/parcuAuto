package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.AlerteResponse;
import com.example.ParcAuto.DTOs.Requests.VoitureRequest;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Maintenance;
import com.example.ParcAuto.Models.Report;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.PortReposiotry;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private PortReposiotry portReposiotry;

    public Voiture addVoiture(VoitureRequest request){
        Voiture voiture = Voiture.builder()
                .port(portReposiotry.findByName(request.getPortName()).orElseThrow(()-> new ObjectNotFoundException("port not found")))
                .numMatricule(request.getNumMatricule())
                .marque(request.getMarque())
                .model(request.getModel())
                .carburant(request.getCarburant())
                .compteurKm(request.getCompteurKm())
                .prochainVidange(request.getProchainVidange())
                .countAccident(0)
                .numChassis(request.getNumChassis())
                .vignette(request.getVignette())
                .carteGrise(request.getCarteGrise())
                .visiteTechnique(request.getVisiteTechnique())
                .statusVoiture(StatusVoiture.disponible)
                .assurance(request.getAssurance())
                .build();
        return voitureRepository.save(voiture);
    }

    public List<Voiture> getLesVoitures(){
        return voitureRepository.findAll();
    }

    public long getVoitureCount(){
        return voitureRepository.count();
    }

    public Voiture getVoiture(Long voitureId){
        return voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
    }
    public List<Voiture> getVoituresByMarque(String marque){
        return voitureRepository.findByMarque(marque);
    }
    public List<Voiture> getVoituresByPortName(String portName){
        return voitureRepository.findByPortName(portName);
    }
    public List<Voiture> getVoituresDisponible(){
        return voitureRepository.findVoituresDispo();
    }
    public List<Voiture> getVoituresIndisponible(){
        return voitureRepository.findTop5VoituresIndispo();
    }




    public Voiture updateVoiture(Long voitureId, VoitureRequest voitureRequest){
        Voiture savedVoiture = voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        savedVoiture.setMarque(voitureRequest.getMarque());
        savedVoiture.setNumMatricule(voitureRequest.getNumMatricule());
        savedVoiture.setNumChassis(voitureRequest.getNumChassis());
        savedVoiture.setCarburant(voitureRequest.getCarburant());
        savedVoiture.setModel(voitureRequest.getModel());
        savedVoiture.setAssurance(voitureRequest.getAssurance());
        savedVoiture.setVignette(voitureRequest.getVignette());
        savedVoiture.setVisiteTechnique(voitureRequest.getVisiteTechnique());
        savedVoiture.setCarteGrise(voitureRequest.getCarteGrise());
        savedVoiture.setCompteurKm(voitureRequest.getCompteurKm());
        savedVoiture.setProchainVidange(voitureRequest.getProchainVidange());
        savedVoiture.setPort(portReposiotry.findByName(voitureRequest.getPortName()).orElseThrow(()-> new ObjectNotFoundException("port not found")));
        return voitureRepository.save(savedVoiture);
    }

    public void deleteVoiture(Long voitureId){
        voitureRepository.deleteById(voitureId);
    }


    public Voiture updateVoitureDispo(Long voitureId) {
        Voiture savedVoiture = voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
         savedVoiture.setStatusVoiture(StatusVoiture.disponible);
        return voitureRepository.save(savedVoiture);
    }
    public Voiture updateVoitureIndispo(Long voitureId) {
        Voiture savedVoiture = voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        savedVoiture.setStatusVoiture(StatusVoiture.indisponible);
        return voitureRepository.save(savedVoiture);
    }
}
