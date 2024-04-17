package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReportRespository extends JpaRepository<Report,Long> {
    Optional<List<Report>> findByEmployeId(Long employeId);

    Optional<List<Report>> findByVoitureId(Long voitureId);

    Optional<List<Report>> findByDateAccident(LocalDate date);

}
