import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice"));
        employees.add(new Employee("Bob"));
        employees.add(new Employee("Anna"));
        employees.add(new Employee("Andrew"));

        // Display names of employees starting with 'A'
        System.out.println("Employee names starting with 'A':");
        for (Employee employee : employees) {
            if (employee.getName().startsWith("A")) {
                System.out.println(employee.getName());
            }
        }
    }
}
