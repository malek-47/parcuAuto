package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.PortRequest;
import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Services.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ports")
public class PortController {
    @Autowired
    private PortService portService;


    @GetMapping
    public List<Port> getAll(){
        return portService.getLesPorts();
    }

    @GetMapping("/{id}")
    public Port getPort(@PathVariable Long id) {return portService.getPort(id);}

    @GetMapping("/{id}/voitures")
    public List<Voiture> getVoituresDePort(@PathVariable Long id) {return portService.getVoituresDePort(id);}

    @PostMapping
    public ResponseEntity<Port> addPort(@RequestBody PortRequest request){
        return ResponseEntity.ok(portService.addPort(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Port> updatePort(@PathVariable Long id, @RequestBody PortRequest request){
        return ResponseEntity.ok(portService.updatePort(id, request));
    }

    @DeleteMapping("/{id}")
    public void deletePort(@PathVariable Long id){
       portService.deletePort(id);
    }
}
