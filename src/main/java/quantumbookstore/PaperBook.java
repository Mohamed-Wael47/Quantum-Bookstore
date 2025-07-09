package quantumbookstore;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        ShippingService.send(address);
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void reduceStock(int quantity) {
        if (stock < quantity)
            throw new RuntimeException("Quantum book store: Not enough stock!");
        stock -= quantity;
    }
}
