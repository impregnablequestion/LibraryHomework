import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    Borrower steve;
    Borrower ben;
    Library mitchell;
    Book paul;
    Book lote;
    Book normalppl;
    Book fake;
    @Before
    public void setUp() {
        steve = new Borrower();
        ben = new Borrower();
        mitchell = new Library(100);
        paul = new Book("Paul", "Daisy Lafarge", "Fiction");
        lote = new Book("Lote", "Shola von Reinhold", "Fantasy");
        normalppl = new Book("Normal People", "Sally Rooney", "Fiction");
        mitchell.addBook(paul);
        mitchell.addBook(lote);
        mitchell.addBook(normalppl);
        fake = new Book("Fake", "Not in", "Collection");
    }
    @Test
    public void canGetTotalBorrowed () {
        assertEquals(0, steve.getTotalBorrowed());
    }
    @Test
    public void canBorrow () {
        steve.borrow(mitchell, paul);
        assertEquals(1, steve.getTotalBorrowed());
    }
    @Test
    public void cantBorrowMoreThanAllowance () {
        steve.borrow(mitchell, paul);
        steve.borrow(mitchell, lote);
        steve.borrow(mitchell, normalppl);
        assertEquals(2, steve.getTotalBorrowed());
    }
    @Test
    public void cantBorrowIfNotInCollection () {
        steve.borrow(mitchell, fake);
        assertEquals(0, steve.getTotalBorrowed());
    }
    @Test
    public void cantBorrowIfAlreadyBorrowed () {
        steve.borrow(mitchell, paul);
        ben.borrow(mitchell, paul);
        assertEquals(0, ben.getTotalBorrowed());
    }
    @Test
    public void canReturnBook () {
        steve.borrow(mitchell, paul);
        steve.returnBook(mitchell, paul);
        assertEquals(0, steve.getTotalBorrowed());
    }

}
