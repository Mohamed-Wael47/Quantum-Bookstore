package quantumbookstore;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        MailService.send(email);
    }

    @Override
    public int getStock() {
        return Integer.MAX_VALUE; // Unlimited
    }

    @Override
    public void reduceStock(int quantity) {
        // No need to reduce for digital
    }
}
