package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
}
