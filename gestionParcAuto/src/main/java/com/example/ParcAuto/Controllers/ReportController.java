package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.PortRequest;
import com.example.ParcAuto.DTOs.Requests.ReportRequest;
import com.example.ParcAuto.Models.Port;
import com.example.ParcAuto.Models.Report;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Services.EmployeService;
import com.example.ParcAuto.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAll(){
        return reportService.getAll();
    }

    @GetMapping("/{id}")
    public Report getReport(@PathVariable Long id) {return reportService.getReport(id);}

    @GetMapping("/employe/{id}")
    public List<Report> getReportsEmploye(@PathVariable Long id) {return reportService.getReportEmplyes(id);}

    @PostMapping("/employe/{id}")
    public ResponseEntity<Report> addReport(@PathVariable Long id, @RequestBody ReportRequest request){
        return ResponseEntity.ok(reportService.addReport(id, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody ReportRequest request){
        return ResponseEntity.ok(reportService.updateReport(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
    }
}
