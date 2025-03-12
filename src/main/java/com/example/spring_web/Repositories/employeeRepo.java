package com.example.spring_web.Repositories;

import com.example.spring_web.entities.employeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepo extends JpaRepository<employeesEntity,Long> {

}
