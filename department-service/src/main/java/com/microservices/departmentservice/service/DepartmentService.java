package com.microservices.departmentservice.service;

import com.microservices.departmentservice.Entity.Department;
import com.microservices.departmentservice.Repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method in DepartmentService");
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {
        log.info("Inside getDepartment method in DepartmentService");
        Department department=departmentRepository.findByDepartmentId(departmentId);
        log.info("Department object retrieved is {}",department);
        return  department;

    }
}
