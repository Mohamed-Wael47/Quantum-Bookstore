package quantumbookstore;

import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Book added - " + book.title);
    }

    public Book removeOutdatedBook(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Book> entry = it.next();
            if ((currentYear - entry.getValue().getYear()) > maxAge) {
                it.remove();
                System.out.println("Quantum book store: Book removed - " + entry.getValue().title);
                return entry.getValue();
            }
        }
        return null;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = books.get(isbn);
        if (book == null)
            throw new RuntimeException("Quantum book store: Book not found!");
        if (!book.isPurchasable())
            throw new RuntimeException("Quantum book store: Book is not purchasable!");

        book.reduceStock(quantity);
        book.handlePurchase(quantity, email, address);

        double totalPrice = book.price * quantity;
        System.out.println("Quantum book store: Purchase complete. Paid: $" + totalPrice);
        return totalPrice;
    }
}
