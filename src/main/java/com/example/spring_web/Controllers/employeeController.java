package com.example.spring_web.Controllers;

import com.example.spring_web.Repositories.employeeRepo;
import com.example.spring_web.entities.employeesEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class employeeController {

    private final employeeRepo employeeRepo;

    public employeeController(employeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    public String getEmployees() {
        return "Hello";
    }

    @GetMapping(path = "/show")
    public List<employeesEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @PostMapping
    public employeesEntity addEmployee(@RequestBody employeesEntity inputEmployee) {
        return employeeRepo.save(inputEmployee);
    }
}
