// Lab 7 icin

public class Product {

    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public void buyOne() {
        if (stock > 0) {
            stock--;
            System.out.println("Successfully bought 1 item! Remaining stock: " + stock);
        } else {
            System.out.println("Out of stock!");
        }
    }

    public void printInfo() {
        System.out.println("Product Name: " + name + " | Stock: " + stock);
    }

    public String getName() {
        return name;
    }
}
