package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.TypeMaintenance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private TypeMaintenance type;
    private String duree;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaintenance;

    @ManyToOne
    @JsonIgnore
    private Voiture voiture;
}
