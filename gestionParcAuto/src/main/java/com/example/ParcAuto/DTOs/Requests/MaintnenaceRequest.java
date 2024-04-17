package com.example.ParcAuto.DTOs.Requests;

import com.example.ParcAuto.Enum.TypeMaintenance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintnenaceRequest {
    private TypeMaintenance type;
    private String duree;
    private long voitureId;
}
