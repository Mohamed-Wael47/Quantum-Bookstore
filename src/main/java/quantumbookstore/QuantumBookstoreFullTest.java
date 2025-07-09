package quantumbookstore;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Book paperBook = new PaperBook("111", "Java Basics", 2018, 100, "Alice", 5);
        Book ebook = new EBook("222", "Python Pro", 2022, 50, "Bob", "PDF");
        Book showcase = new ShowcaseBook("333", "C++ Legacy", 2010, 0, "Carol");

        inventory.addBook(paperBook);
        inventory.addBook(ebook);
        inventory.addBook(showcase);

        inventory.buyBook("111", 2, "test@example.com", "Cairo, Egypt");
        inventory.buyBook("222", 1, "reader@example.com", "");

        inventory.removeOutdatedBook(5);

        // Uncomment to test exception
        // inventory.buyBook("333", 1, "", "");
    }
}
