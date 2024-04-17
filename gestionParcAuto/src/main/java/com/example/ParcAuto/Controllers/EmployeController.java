package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.DTOs.Requests.LoginRequest;
import com.example.ParcAuto.DTOs.Requests.LoginResponse;
import com.example.ParcAuto.DTOs.Requests.RegisterRequest;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping
    public List<Employe> getAll(){
        return employeService.getAll();
    }

    @GetMapping("/{id}")
    public Employe getEmploye(@PathVariable Long id) {return employeService.getEmploye(id);}

    @PostMapping("/login")
    public LoginResponse Login(@RequestBody LoginRequest request){
        return employeService.login(request);
    }
    @PostMapping
    public ResponseEntity<Employe> addEmploye(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(employeService.addEmploye(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody RegisterRequest request){
        return ResponseEntity.ok(employeService.updateEmploye(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id){
        employeService.deleteEmploye(id);
    }
}
