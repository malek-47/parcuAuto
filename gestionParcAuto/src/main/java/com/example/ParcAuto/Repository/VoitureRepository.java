package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    List<Voiture> findByMarque(String marque);

    List<Voiture> findByPortName(String portName);

    long countByStatusVoiture(StatusVoiture statusVoiture);

    @Query("select v.port.name, count(v) from Voiture v group by v.port.name")
    List<Object> findVoituresByPort();

    @Query("select v from Voiture v where v.statusVoiture = disponible")
    List<Voiture> findVoituresDispo();
    @Query("select v from Voiture v where v.statusVoiture = indisponible")
    List<Voiture> findTop5VoituresIndispo();
}
