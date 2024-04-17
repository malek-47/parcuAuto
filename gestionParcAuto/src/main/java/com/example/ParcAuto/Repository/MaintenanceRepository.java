package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Enum.TypeMaintenance;
import com.example.ParcAuto.Models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
    List<Maintenance> findByDateMaintenance( LocalDate date);
}
