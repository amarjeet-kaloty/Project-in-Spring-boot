package com.Springboot.Project_in_Spring_boot.service;

import com.Springboot.Project_in_Spring_boot.entity.Department;
import com.Springboot.Project_in_Spring_boot.error.DepartmentNotFoundException;
import com.Springboot.Project_in_Spring_boot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not found!");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Optional.ofNullable(department.getDepartmentCode())
                .map(code -> !"".equalsIgnoreCase(code))
                .orElse(false)) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Optional.ofNullable(department.getDepartmentName())
                .map(code -> !"".equalsIgnoreCase(code))
                .orElse(false)) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Optional.ofNullable(department.getDepartmentAddress())
                .map(code -> !"".equalsIgnoreCase(code))
                .orElse(false)) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
       return departmentRepository.findByDepartmentName(departmentName);
    }

}
