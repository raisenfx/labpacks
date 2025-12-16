public class Main {
    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        manager.loadEmployeesFromFile("q3.txt");
        manager.displayEmployees();

        System.out.println("---- Search Result ----");
        manager.searchEmployee("Gandalf the Grey");

        manager.addEmployee("Bilbo Baggins", "Finance", "bilbo@shire.com");
    }
}

