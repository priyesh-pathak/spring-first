package com.example.spring_web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeesDTO {
    private Long id;
    private String name;
    private String department;


}
