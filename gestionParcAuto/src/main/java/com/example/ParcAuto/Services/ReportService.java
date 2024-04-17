package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.ReportRequest;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Report;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.ReportRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRespository reportRepository;
    @Autowired
    private EmployeRepository employeRepository;

    public Report addReport(Long employeId, ReportRequest request){
        Report report = Report.builder()
                .subject(request.getSubject())
                .description(request.getDescription())
                .employe(employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found")))
                .build();
        return reportRepository.save(report);
    }

    public List<Report> getAll(){
        return reportRepository.findAll();
    }

    public Report getReport(Long reportId){
        return reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
    }
    public List<Report> getReportEmplyes(Long employeId){
        return reportRepository.findByEmployeId(employeId).orElseThrow(()-> new ObjectNotFoundException("reports not found"));
    }

    public Report updateReport(Long reportId, ReportRequest request){
        Report savedReport = reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
        savedReport.setSubject(request.getSubject());
        savedReport.setDescription(request.getDescription());

        return reportRepository.save(savedReport);
    }

    public void deleteReport(Long reportId){
       reportRepository.deleteById(reportId);
    }
}
