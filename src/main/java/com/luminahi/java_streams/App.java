package com.luminahi.java_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.luminahi.java_streams.lib.Employee;
import static com.luminahi.java_streams.lib.Gender.*;

public class App {

    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(    
            new Employee("alex", 20, MALE, 3000),
            new Employee("sara", 17, FEMALE, 3200),
            new Employee("sora", 15, FEMALE, 2500),
            new Employee("mary", 25, FEMALE, 1800),
            new Employee("bruno", 30, MALE, 2800)
        );

        var isBiggerThanMinSalary = employees
            .stream()
            .anyMatch((employee) -> employee.Salary() > 1400);
        
        var isAllFemales = employees
            .stream()
            .allMatch(e -> e.gender() == FEMALE);

        var allFemales = employees
            .stream()
            .filter(e -> e.gender() == FEMALE);

        employees
            .stream()
            .sorted(Comparator.comparing(Employee::age))
            .forEach(System.out::println);

        employees.stream()
            .max(Comparator.comparing(Employee::age))
            .ifPresent(e -> System.out.println("Max Age: " + e.age()));

        employees.stream()
            .min(Comparator.comparing(Employee::age))
            .ifPresent(e -> System.out.println("Min Age: " + e.age()));

        employees
            .stream()
            .map(e -> e.name())
            .forEach(System.out::println);

        List<List<String>> lists = Arrays.asList(
            Arrays.asList("elena", "mary"),
            Arrays.asList("robert", "hermes"),
            Arrays.asList("sara", "george")
        );
        
        lists
            .stream()
            .flatMap(List::stream)
            .forEach(System.out::println);

        System.out.println(isBiggerThanMinSalary);
        System.out.println(isAllFemales);
        allFemales.forEach(System.out::println);
    }
}
