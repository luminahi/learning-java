package record;

import record.lib.Employee;

/**
 * App
 */
class Program {

    public static void main(String[] args) {
        Employee employee0 = new Employee("alex", 2000);
        Employee employee1 = new Employee("alex", 2000);

        int hashCode0 = employee0.hashCode();
        int hashCode1 = employee1.hashCode();

        System.out.println(employee0.equals(employee1));
    }
}
