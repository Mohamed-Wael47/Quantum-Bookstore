package quantumbookstore;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        throw new RuntimeException("Quantum book store: Showcase books cannot be purchased!");
    }

    @Override
    public int getStock() {
        return 0;
    }

    @Override
    public void reduceStock(int quantity) {
        throw new RuntimeException("Quantum book store: Not allowed.");
    }
}
