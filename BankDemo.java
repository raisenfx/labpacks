import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount acc1 = new BankAccount("20240602089", 1000);
        BankAccount acc2 = new BankAccount("20250602089", 5000);

        System.out.println("Two accounts created:");
        acc1.accountDetails();
        acc2.accountDetails();

        while (true) {
            System.out.println("\n----- BANK MENU -----");
            System.out.println("1 → Deposit");
            System.out.println("2 → Withdraw");
            System.out.println("3 → Account Details");
            System.out.println("4 → Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            System.out.print("Which account? (1 or 2): ");
            int accChoice = scanner.nextInt();

            BankAccount selected = (accChoice == 1) ? acc1 : acc2;

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = scanner.nextDouble();
                    selected.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double wd = scanner.nextDouble();
                    selected.withdraw(wd);
                    break;

                case 3:
                    selected.accountDetails();
                    break;

                case 4:
                    System.out.println("Exiting system...");


                    System.out.println("\nChanging Account 1 ID...");
                    String oldID = acc1.getAccountID();
                    acc1.setAccountID("20240602089");
                    System.out.println("Old ID = " + oldID);
                    System.out.println("New ID = " + acc1.getAccountID());

                    System.out.println("\nFinal account states:");
                    acc1.accountDetails();
                    acc2.accountDetails();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
