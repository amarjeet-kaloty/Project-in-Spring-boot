package com.Springboot.Project_in_Spring_boot.repository;

import com.Springboot.Project_in_Spring_boot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
            Department.builder()
                    .departmentName("IT")
                    .departmentAddress("Orlando, FL")
                    .departmentCode("CS-02")
                    .departmentId(1L)
                    .build();

        entityManager.persist(department);
    }

    @Test
    public void GetDepartmentByID_ReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "IT");
    }
}