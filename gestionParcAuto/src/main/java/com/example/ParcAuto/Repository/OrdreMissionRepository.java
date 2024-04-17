package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Enum.StatusMission;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Models.OrdreMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdreMissionRepository extends JpaRepository<OrdreMission,Long> {
    List<OrdreMission> findByEmployeId(Long employeId);

    List<OrdreMission> findByVoitureId(Long voitureId);

    long countByStatusMission(StatusMission statusMission);

}
