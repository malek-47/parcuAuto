package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.MissionRequest;
import com.example.ParcAuto.DTOs.Requests.PortRequest;
import com.example.ParcAuto.Models.Consommation;
import com.example.ParcAuto.Models.OrdreMission;
import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Services.OrdreMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class OrdreMissionController {
    @Autowired
    private OrdreMissionService ordreMissionService;

    @GetMapping
    public List<OrdreMission> getAll(){
        return ordreMissionService.getAllMissions();
    }

    @GetMapping("/{id}")
    public OrdreMission getOrdreMission(@PathVariable Long id) {return ordreMissionService.getOrdreMission(id);}

    @GetMapping("/employe/{id}")
    public List<OrdreMission> getOrdreMissionByEmploye(@PathVariable Long id) {return ordreMissionService.getMissionsByEmployeId(id);}

    @GetMapping("/voiture/{id}")
    public List<OrdreMission> getOrdreMissionByVoiture(@PathVariable Long id) {return ordreMissionService.getMissionsByVoitureId(id);}


    @PostMapping("/employe/{id}")
    public ResponseEntity<OrdreMission> addMission(@PathVariable Long id, @RequestBody MissionRequest request){
        return ResponseEntity.ok(ordreMissionService.addMission(id, request));
    }

    @PutMapping("/{id}/consommation")
    public ResponseEntity<OrdreMission> ajoutConsommation(@PathVariable Long id, @RequestBody Consommation consommation){
        return ResponseEntity.ok(ordreMissionService.ajoutConsommation(id, consommation));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrdreMission> updateMission(@PathVariable Long id, @RequestBody MissionRequest request){
        return ResponseEntity.ok(ordreMissionService.updateMission(id, request));
    }

    @PutMapping("/{id}/ok")
    public ResponseEntity<OrdreMission> updateStatusV(@PathVariable Long id){
        return ResponseEntity.ok(ordreMissionService.changeMissionStatus(id,"ok"));
    }
    @PutMapping("/{id}/ko")
    public ResponseEntity<OrdreMission> updateStatusR(@PathVariable Long id){
        return ResponseEntity.ok(ordreMissionService.changeMissionStatus(id,"ko"));
    }

    @DeleteMapping("/{id}")
    public void deleteMission(@PathVariable Long id){
        ordreMissionService.deleteMission(id);
    }
}
