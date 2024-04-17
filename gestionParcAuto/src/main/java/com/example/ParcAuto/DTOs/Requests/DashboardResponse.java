package com.example.ParcAuto.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponse {
    private long numMission;
    private long numClient;
    private long numVoiture;
    private long numReport;
    private long voitureDispo;
    private long voitureIndispo;
    private long missionV;
    private long missionE;
    private long missionA;
    private List<Object> voitureParPort;
    private List<AlerteResponse> alerts;
}
