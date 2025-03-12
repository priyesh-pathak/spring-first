package com.example.spring_web.Services;

import com.example.spring_web.Repositories.employeeRepo;
import com.example.spring_web.dto.EmployeesDTO;
import com.example.spring_web.entities.employeesEntity;
import org.aspectj.util.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final ModelMapper mp;
    private final employeeRepo employeeRepo;

    public EmployeeService(employeeRepo employeeRepo, ModelMapper mp) {
        this.employeeRepo = employeeRepo;
        this.mp = mp;
    }

    public List<EmployeesDTO> findAll() {
        List<employeesEntity> output = employeeRepo.findAll();
        return output.stream()
                .map(entity -> mp.map(entity, EmployeesDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeesDTO save(EmployeesDTO inputEmployee) {
        employeesEntity input = mp.map(inputEmployee, employeesEntity.class);
        employeesEntity output = employeeRepo.save(input);
        return mp.map(output, EmployeesDTO.class);
    }

    public EmployeesDTO update(Long id, EmployeesDTO old) {
        employeesEntity oldEntity=mp.map(old, employeesEntity.class);
        oldEntity.setId(id);
        employeesEntity newEntity = employeeRepo.save(oldEntity);
        return mp.map(newEntity, EmployeesDTO.class);
    }
    public boolean ifExist(long id){
        return employeeRepo.existsById(id);
    }
    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    public EmployeesDTO patch(Map<String, Object> updates, Long id) {
        boolean exists=ifExist(id);
        if(!exists) throw new RuntimeException("Employee not found");
        employeesEntity oldEntity=employeeRepo.findById(id).get();
        updates.forEach((field, value) ->{
            Field f=ReflectionUtils.findRequiredField(employeesEntity.class,field);
            f.setAccessible(true);
            ReflectionUtils.setField(f, oldEntity, value);
        });
        return mp.map(employeeRepo.save(oldEntity),EmployeesDTO.class);
    }
}
