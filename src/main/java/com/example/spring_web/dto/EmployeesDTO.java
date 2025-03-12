package com.example.spring_web.dto;


public class EmployeesDTO {
    private Long id;
    private String name;
    private String department;

    public EmployeesDTO() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeesDTO(Long id, String department, String name) {
        this.id = id;
        this.department = department;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeesDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
