package com.example.ParcAuto.Models;

import com.example.ParcAuto.DTOs.Requests.VoitureRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "port", cascade = CascadeType.ALL)
    private List<Voiture> voitureList;

//    public void addVoitures(List<VoitureRequest> voitureRequests) {
//        for (VoitureRequest request: voitureRequests) {
//            voitureList.add(Voiture.builder()
//                            .marque(request.getMarque())
//                            .numMatricule(request.getNumMatricule()).build());
//        }
//    }
}
