package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.Fonction;
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
public class Employe extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Fonction fonction;
    private String username;
    private String password;



    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<OrdreMission> mesMissions = new ArrayList<>();

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Report> mesReports = new ArrayList<>();
}
