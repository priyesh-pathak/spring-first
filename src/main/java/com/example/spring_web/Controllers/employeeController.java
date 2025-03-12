package com.example.spring_web.Controllers;

import com.example.spring_web.Services.EmployeeService;
import com.example.spring_web.dto.EmployeesDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class employeeController {  // ✅ Kept your naming

    private final EmployeeService employeeService;

    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ✅ Explicitly setting response type to prevent media type errors
    @GetMapping(produces = "text/plain")
    public String getEmployees() {
        return "Hello";
    }

    @GetMapping(path = "/show", produces = "application/json") // ✅ Explicit JSON response
    public List<EmployeesDTO> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json") // ✅ Explicit JSON request & response
    public EmployeesDTO addEmployee(@RequestBody EmployeesDTO inputEmployee) {
        return employeeService.save(inputEmployee);
    }
    @PutMapping(path="/{id}")
    public EmployeesDTO updateEmployee(@RequestBody EmployeesDTO old,@PathVariable Long id){
        return employeeService.update(id, old);
    }
    @DeleteMapping(path="/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
    }
    @PatchMapping(path="/{id}")
    public EmployeesDTO patchEmployee(@RequestBody Map<String,Object> updates, @PathVariable Long id){
        return employeeService.patch(updates,id);
    }
}
