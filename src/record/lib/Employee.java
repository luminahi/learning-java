package record.lib;

import java.util.Objects;

public class Employee {
    
    private final String name;
    private final int employeeNumber;

    public Employee(String name, int employeeNumber) {
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

        Employee employee = (Employee) obj;

        return Objects.equals(name, employee.name) 
        && Objects.equals(employeeNumber, employee.employeeNumber);
    }
}