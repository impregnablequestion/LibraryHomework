import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Library pollokshieldsLib;
    Book lote;

    @Before
    public void setUp () {
        pollokshieldsLib = new Library(20);
        lote = new Book("Lote","Shola von Reinhold", "Fantasy");

    }
    @Test
    public void canGetTotalBooks () {
        assertEquals(0, pollokshieldsLib.getTotalBooks());
    }
    @Test
    public void canAddBook () {
        pollokshieldsLib.addBook(lote);
        assertEquals(1, pollokshieldsLib.getTotalBooks());
    }
    @Test
    public void cantAddBookIfStockFull () {
        Library tinyLib = new Library(2);
        Book paul = new Book("Paul", "Daisy Lafarge", "Fiction");
        Book normalppl = new Book("Normal People", "Sally Rooney", "Fiction");
        tinyLib.addBook(lote);
        tinyLib.addBook(paul);
        tinyLib.addBook(normalppl);
        assertEquals(2, tinyLib.getTotalBooks());
    }
}
