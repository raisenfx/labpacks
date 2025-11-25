public class Book {

    String title;
    int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public void addPages(int amount) {
        if (amount > 0) {
            pages += amount;
        }
    }


    public void printBook() {
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
    }
}
