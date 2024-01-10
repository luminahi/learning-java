package record;

import record.lib.EmployeeClass;
import record.lib.EmployeeRecord;

/**
 * App
 */
class Program {

    public static void main(String[] args) {
        EmployeeClass employeeClass0 = new EmployeeClass("alex", 2000);
        EmployeeClass employeeClass1 = new EmployeeClass("alex", 2000);

        EmployeeRecord employeeRecord0 = new EmployeeRecord("sora", 4000);
        EmployeeRecord employeeRecord1 = new EmployeeRecord("sora", 4000);

        System.out.println(employeeRecord0.equals(employeeRecord1));
        System.out.println(employeeClass0.equals(employeeClass1));
        
        System.out.println(employeeClass0.hashCode());
        System.out.println(employeeClass1.hashCode());

        System.out.println(employeeRecord0.hashCode());
        System.out.println(employeeRecord1.hashCode());

        System.out.println(EmployeeRecord.getWrappedCode());
    }
}
