package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.DashboardResponse;
import com.example.ParcAuto.DTOs.Requests.LoginRequest;
import com.example.ParcAuto.DTOs.Requests.LoginResponse;
import com.example.ParcAuto.DTOs.Requests.RegisterRequest;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Services.DashService;
import com.example.ParcAuto.Services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dash")
public class DashboardController {
    @Autowired
    private DashService dashService;

    @GetMapping
    public DashboardResponse getAll(){
        return dashService.getDashData();
    }

}
