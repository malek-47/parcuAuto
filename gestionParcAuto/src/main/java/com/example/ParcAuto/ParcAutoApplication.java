package com.example.ParcAuto;

import com.example.ParcAuto.Enum.Fonction;
import com.example.ParcAuto.Enum.TypeMaintenance;
import com.example.ParcAuto.Models.*;
import com.example.ParcAuto.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ParcAutoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParcAutoApplication.class, args);
	}

	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private MaintenanceRepository maintenanceRepository;
	@Autowired
	private OrdreMissionRepository ordreMissionRepository;
	@Autowired
	private PortReposiotry portReposiotry;

	@Override
	public void run(String... args) throws Exception {
//		Employe employe = Employe.builder()
//				.firstName("malek")
//				.lastName("skhiri")
//				.email("malek@gmail.com")
//				.fonction(Fonction.Pdg)
//				.build();
//
//		Voiture voiture = Voiture.builder()
//				.marque("Caddy")
//				.numMatricule("254111789")
//				.maintenanceList(List.of())
//				.build();
//		Voiture voiture2 = Voiture.builder()
//				.marque("Picanto")
//				.numMatricule("145788456")
//				.build();
//		Port port = Port.builder()
//				.location("Sidi bousaid")
//				.name("bort sidi bou")
//				.voitureList(List.of(voiture,voiture2))
//				.build();
//		voiture.setPort(port);
//		voiture2.setPort(port);
//
//		Maintenance maintenance = Maintenance.builder().type(TypeMaintenance.Vidange).voiture(voiture).build();
//		Maintenance maintenance2 = Maintenance.builder().type(TypeMaintenance.Accident).voiture(voiture2).build();
//
//		OrdreMission ordreMission = OrdreMission.builder()
//				.dateDebut(new Date())
//				.dateFin(new Date())
//				.locationDebut("menzah")
//				.locationFin("rades")
//				.employe(employe)
//				.voiture(voiture)
//				.build();
//
//		employeRepository.save(employe);
//		portReposiotry.save(port);
//		ordreMissionRepository.save(ordreMission);
//		maintenanceRepository.save(maintenance);
//		maintenanceRepository.save(maintenance2);



	}
}
