package com.Springboot.Project_in_Spring_boot.controller;

import com.Springboot.Project_in_Spring_boot.entity.Department;
import com.Springboot.Project_in_Spring_boot.error.DepartmentNotFoundException;
import com.Springboot.Project_in_Spring_boot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        LOGGER.info("Inside saveDepartment: DepartmentController.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList: DepartmentController.");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById: DepartmentController.");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside deleteDepartmentById: DepartmentController.");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        LOGGER.info("Inside updateDepartment: DepartmentController.");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        LOGGER.info("Inside fetchDepartmentByName: DepartmentController.");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
