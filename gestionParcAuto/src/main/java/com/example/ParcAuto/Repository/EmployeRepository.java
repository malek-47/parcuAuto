package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
    Optional<Employe> findByUsername(String username);

    
}
