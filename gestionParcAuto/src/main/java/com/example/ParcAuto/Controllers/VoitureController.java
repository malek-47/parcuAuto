package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.VoitureRequest;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @GetMapping
    public List<Voiture> getAll(){
        return voitureService.getLesVoitures();
    }

    @GetMapping("/{id}")
    public Voiture getVoiture(@PathVariable Long id){
        return voitureService.getVoiture(id);
    }

    @GetMapping("/marque/{marque}")
    public List<Voiture> getVoituresByMarque(@PathVariable String marque){
        return voitureService.getVoituresByMarque(marque);
    }
    @GetMapping("/port/{portName}")
    public List<Voiture> getVoituresByPortName(@PathVariable String portName){
        return voitureService.getVoituresByPortName(portName);
    }

    @GetMapping("/dispo")
    public List<Voiture> getVoituresDispo(){
        return voitureService.getVoituresDisponible();
    }
    @GetMapping("/indispo")
    public List<Voiture> getVoituresIndispo(){
        return voitureService.getVoituresIndisponible();
    }

    @PostMapping
    public Voiture addVoiture(@RequestBody VoitureRequest request){
        return voitureService.addVoiture(request);
    }

    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable Long id,@RequestBody VoitureRequest request){
        return voitureService.updateVoiture(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id){
         voitureService.deleteVoiture(id);
    }
}
