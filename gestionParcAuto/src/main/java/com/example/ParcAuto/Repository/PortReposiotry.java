package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PortReposiotry extends JpaRepository<Port,Long> {
    Optional<Port> findByName(String portName);


}
