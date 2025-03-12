package com.example.spring_web.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class employeeController {
//    @GetMapping
//    public String welcome() {
//        return "Hello from EmployeeController!";
//    }
    @GetMapping
    public String getEmployees(@RequestParam String name) {
        return "Hello "+ name;
    }
}
