package com.Springboot.Project_in_Spring_boot.error;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
