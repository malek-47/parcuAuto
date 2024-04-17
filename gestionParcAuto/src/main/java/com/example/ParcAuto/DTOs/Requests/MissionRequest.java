package com.example.ParcAuto.DTOs.Requests;

import com.example.ParcAuto.Enum.StatusMission;
import com.example.ParcAuto.Models.Consommation;
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
public class MissionRequest {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String locationDebut;
    private String locationFin;
    private List<String> companions = new ArrayList<>();
    private Long voitureId;
    private Consommation consommation;

}
