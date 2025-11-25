//Lab7 icin

public class BookDemo {
    public static void main(String[] args) {


        Book b1 = new Book("Harry Potter", 300);
        Book b2 = b1;


        b2.addPages(20);

        System.out.println("---- b1 ----");
        b1.printBook();

        System.out.println("---- b2 ----");
        b2.printBook();

        Book b3 = new Book("Harry Potter", 320); // same values

        System.out.println("\nComparing references:");
        System.out.println(b1);
        System.out.println(b3);

        System.out.println("\nComparing field values:");
        System.out.println("b1.title equals b3.title? " + b1.title.equals(b3.title));
        System.out.println("b1.pages equals b3.pages? " + (b1.pages == b3.pages));

    }
}


