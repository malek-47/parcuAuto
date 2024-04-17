package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.Carburant;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marque;
    private StatusVoiture statusVoiture;
    private String numMatricule;
    //new
    private String model;
    private String numChassis;
    private Carburant carburant;
    private Long compteurKm;
    private Long prochainVidange;
    private Integer countAccident;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate assurance;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate visiteTechnique;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate carteGrise;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate vignette;

    @ManyToOne
    @JsonIgnore
    private Port port;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrdreMission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Maintenance> maintenanceList = new ArrayList<>();

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Report> accidentList = new ArrayList<>();
}
