package com.example.ParcAuto.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoitureRequest {
    private String marque;
    private String numMatricule;
    private String portName;
}
