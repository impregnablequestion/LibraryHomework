import java.util.ArrayList;

public class Borrower {
    private ArrayList<Book> borrowed;
    private int bookAllowance;

    public Borrower() {
        this.borrowed = new ArrayList<>();
        this.bookAllowance = 2;
    }
    public int getTotalBorrowed() {
        return this.borrowed.size();
    }
    public void borrow (Library library, Book book) {
        boolean loan = library.lend(book);
        if (getTotalBorrowed() < this.bookAllowance && loan) {
            this.borrowed.add(book);
        }
    }
    public void returnBook (Library library, Book book) {
        boolean returnAccepted = library.acceptReturn(book);
        if (returnAccepted) {
            this.borrowed.remove(book);
        }
    }
}
