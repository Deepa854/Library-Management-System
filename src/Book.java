public class Book {
    private int id;
    private String title;
    private String author;
    private int qty;

    public Book(int id, String title, String author, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | Qty: " + qty;
    }
}
