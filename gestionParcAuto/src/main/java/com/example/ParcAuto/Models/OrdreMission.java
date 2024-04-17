package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.StatusMission;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    private String locationDebut;
    private String locationFin;
    private List<String> compagnons  = new ArrayList<>();
    private String conducteur;
    //new
    private String duree;


    @ManyToOne
    @JsonIgnore
    private Employe employe;
    @ManyToOne
    private Voiture voiture;
    @Embedded
    private Consommation consommation;

}
