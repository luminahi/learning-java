package collector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.HashMap;
// import java.util.function.Function;
// import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import collector.lib.Employee;

public class App {
    

    public static void main(String[] args) throws IOException {
        
        // Function<Employee, Integer> fn1 = Employee::getSalary;
        // ToIntFunction<Employee> fn2 = Employee::getSalary;

        
        // Collector<Employee, ?, Long> count = Collectors.counting();
        // Collector<Employee, ?, Double> avg = Collectors.averagingInt(Employee::salary);

        Employee alex = new Employee("design", 1400);
        Employee sora = new Employee("design", 2000);
        Employee sara = new Employee("hr", 3000);
        Employee karen = new Employee("programming", 900);

        // List<Employee> employees = Arrays.asList(alex, sora, sara, karen);

        // var result = employees.stream().collect(summingSalaries);
        // var countRes = employees.stream().collect(count);
        // var avgRes = employees.stream().collect(avg);

        // System.out.println(result);
        // System.out.println(countRes);
        // System.out.println(avgRes);

        // Collector<Employee, ?, Map<String, Employee>> collector = Collectors.groupingBy((value) -> value, summingSalaries);
        
        Collector<Employee, ?, Integer> summingSalaries = Collectors.summingInt(Employee::salary);
        Collector<Employee, ?, Map<String, Integer>> collector = Collectors.groupingBy(Employee::department, summingSalaries);
        
        Stream<Employee> employeeStream = Arrays.asList(alex, sora, sara, karen).stream();

        Map<String, Integer> employeeMap = employeeStream.collect(collector);

        employeeMap.forEach((key, value) -> System.out.println(key + ", " + value));
    }
}
