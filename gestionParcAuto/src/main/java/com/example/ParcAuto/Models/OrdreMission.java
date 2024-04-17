package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.StatusMission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrdreMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private StatusMission statusMission;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    private String locationDebut;
    private String locationFin;
    private List<String> compagnons  = new ArrayList<>();
    private String conducteur;

    @ManyToOne
    @JsonIgnore
    private Employe employe;
    @ManyToOne
    private Voiture voiture;
    @Embedded
    private Consommation consommation;

}
