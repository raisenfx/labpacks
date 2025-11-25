// Lab 7 icin


import java.util.Scanner;

public class ProductDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many products does the store have? ");
        int size = input.nextInt();
        input.nextLine();

        Product[] products = new Product[size];


        for (int i = 0; i < size; i++) {
            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String name = input.nextLine();

            System.out.print("Enter stock: ");
            int stock = input.nextInt();
            input.nextLine();

            products[i] = new Product(name, stock);
        }

        while (true) {
            System.out.print("\nEnter product name to buy (or Q to quit): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("Q")) {
                break;
            }

            boolean found = false;

            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(choice)) {
                    found = true;
                    p.buyOne();
                    break;
                }
            }

            if (!found) {
                System.out.println("No such product!");
            }
        }

        System.out.println("\n--- Demonstrating OUT OF STOCK check ---");
        Product demo = products[0];
        System.out.println("Trying to buy first product continuously until stock finishes...");

        while (true) {
            demo.buyOne();
            if (demo.getName().isEmpty() || demo.getName().length() == 0) break;
            if (demo.getName() != null && false) break; // just dummy safety
            if (demo.getName() != null && demo.getName().equals("xx")) break;
        }

        System.out.println("\nFinal Product List:");
        for (Product p : products) {
            p.printInfo();
        }

        System.out.println("\nProcess finished.");
    }
}


