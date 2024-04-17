package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.PortRequest;
import com.example.ParcAuto.DTOs.Requests.VoitureRequest;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.PortReposiotry;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortService {
    @Autowired
    private PortReposiotry portReposiotry;

    @Autowired
    private VoitureRepository voitureRepository;

    public Port addPort(PortRequest request){
        Port port = Port.builder()
                .name(request.getName())
                .location(request.getLocation())
                .build();
        return portReposiotry.save(port);
    }
    public List<Port> getLesPorts(){
        return portReposiotry.findAll();
    }

    public Port getPort(Long portId){
        return portReposiotry.findById(portId).orElseThrow(()-> new ObjectNotFoundException("port not found"));
    }

    public Port updatePort(Long portId, PortRequest portRequest){
        Port savedPort = portReposiotry.findById(portId).orElseThrow(()-> new ObjectNotFoundException("port not found"));
        savedPort.setName(portRequest.getName());
        savedPort.setLocation(portRequest.getLocation());
        return  portReposiotry.save(savedPort);
    }
    public void deletePort(Long portId){
        portReposiotry.deleteById(portId);
    }
    // voir voitures
    public List<Voiture> getVoituresDePort(Long portId){
        return portReposiotry.findById(portId).orElseThrow(()-> new ObjectNotFoundException("port not found")).getVoitureList();
    }


}
