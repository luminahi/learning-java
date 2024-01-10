package record.lib;

public record EmployeeRecord(String name, int employeeNumber) {
    // optional
    public EmployeeRecord {
        if (name == "") throw new IllegalArgumentException();
    }

    private static final int EMPLOYEE_CODE = 100;

    public static int getWrappedCode() {
        return EMPLOYEE_CODE;
    }
}
