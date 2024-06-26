package com.example.ParcAuto.DTOs.Requests;

import com.example.ParcAuto.Enum.TypeMaintenance;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintnenaceRequest {
    private TypeMaintenance type;
    private String duree;
    private long voitureId;
    private String frais;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateMaintenance;
}
