package com.luminahi.record.lib;

import java.util.Objects;

public class EmployeeClass {
    
    private final String name;
    private final int employeeNumber;

    public EmployeeClass(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getEmployeeNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.employeeNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        EmployeeClass employee = (EmployeeClass) obj;

        return Objects.equals(name, employee.name) 
        && Objects.equals(employeeNumber, employee.employeeNumber);
    }
}