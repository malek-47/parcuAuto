package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.MaintnenaceRequest;
import com.example.ParcAuto.DTOs.Requests.PortRequest;
import com.example.ParcAuto.Models.Maintenance;
import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAll(){
        return maintenanceService.getLesMaintenances();
    }

    @GetMapping("/{id}")
    public Maintenance getMaintenance(@PathVariable Long id) {return maintenanceService.getMaintenance(id);}

    @PostMapping
    public ResponseEntity<Maintenance> addMaintenance(@RequestBody MaintnenaceRequest request){
        return ResponseEntity.ok(maintenanceService.addMaintenance(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id, @RequestBody MaintnenaceRequest request){
        return ResponseEntity.ok(maintenanceService.updateMaintenance(id,request));
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenance(@PathVariable Long id){
        maintenanceService.deleteMaintenance(id);
    }

}
