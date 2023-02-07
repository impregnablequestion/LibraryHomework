import java.util.ArrayList;

public class Library {
    private ArrayList<Book> collection;
    private int capacity;

    public Library(Integer capacity) {
        this.collection = new ArrayList<>();
        this.capacity = capacity;
    }
    public int getTotalBooks(){
        return this.collection.size();
    }
    public void addBook (Book book) {
        int stock = getTotalBooks();
        if (stock < this.capacity) {
            this.collection.add(book);
        }
    }
    public boolean lend (Book book) {
        if (book.getAvailable() && this.collection.contains(book)) {
            book.toggleAvailable();
            return true;
        } else {
            return false;
        }
    }
    public boolean acceptReturn (Book book) {
        if (!book.getAvailable() && this.collection.contains(book)) {
            book.toggleAvailable();
            return true;
        } else {
            return false;
        }
    }
}
