package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Port;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortReposiotry extends JpaRepository<Port,Long> {
    Optional<Port> findByName(String portName);
}
