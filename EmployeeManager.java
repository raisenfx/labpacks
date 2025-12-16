import java.io.*;

public class EmployeeManager {

    private Employee[] employees;
    private int count;

    public EmployeeManager() {
        employees = new Employee[100];
        count = 0;
    }

    public void loadEmployeesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String name = parts[0].trim();
                String department = parts[1].trim();
                String email = parts[2].trim();

                employees[count++] = new Employee(name, department, email);
            }
        } catch (IOException e) {
            System.out.println("File read error!");
        }
    }

    public void displayEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void addEmployee(String name, String department, String email) {
        Employee emp = new Employee(name, department, email);
        employees[count++] = emp;

        try (PrintWriter pw = new PrintWriter(new FileWriter("q3.txt", true))) {
            pw.println(name + ", " + department + ", " + email);
        } catch (IOException e) {
            System.out.println("File write error!");
        }
    }

    public void searchEmployee(String name) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}
