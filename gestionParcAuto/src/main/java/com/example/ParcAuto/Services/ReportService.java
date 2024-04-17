package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.AlerteResponse;
import com.example.ParcAuto.DTOs.Requests.ReportRequest;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Maintenance;
import com.example.ParcAuto.Models.Report;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.ReportRespository;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRespository reportRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private VoitureRepository voitureRepository;

    public Report addReport(Long employeId, ReportRequest request){
        Voiture voiture = voitureRepository.findById(request.getVoitureId()).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));

        Report report = Report.builder()
                .sujet(request.getSubject())
                .description(request.getDescription())
                .employe(employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found")))
                .voiture(voiture)
                .dateAccident(request.getDateAccident())
                .lieuxAccident(request.getLieuxAccident())
                .build();
        voiture.setStatusVoiture(StatusVoiture.indisponible);
        voiture.setCountAccident(voiture.getCountAccident()+1);
        voitureRepository.save(voiture);
        return reportRepository.save(report);
    }

    public List<Report> getAll(){
        return reportRepository.findAll();
    }



    public Report getReport(Long reportId){
        return reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
    }
    public List<Report> getReportEmplyes(Long employeId){
        return reportRepository.findByEmployeId(employeId).orElseThrow(()-> new ObjectNotFoundException("No incidents found"));
    }
    public List<Report> getReportVoitures(Long voitureId){
        return reportRepository.findByVoitureId(voitureId).orElseThrow(()-> new ObjectNotFoundException("No incidents found"));
    }

    public Report updateReport(Long reportId, ReportRequest request){
        Report savedReport = reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
        savedReport.setSujet(request.getSubject());
        savedReport.setDescription(request.getDescription());

        return reportRepository.save(savedReport);
    }

    public void deleteReport(Long reportId){

        Report report = reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
        Voiture voiture = report.getVoiture();
        voiture.setStatusVoiture(StatusVoiture.disponible);
        voitureRepository.save(voiture);
        reportRepository.delete(report);
    }
}
