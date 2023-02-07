import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LibraryTest {
    Library pollokshieldsLib;
    Book lote;
    Book paul;
    Book normalppl;
    Book arizona;
    Book signs;

    @Before
    public void setUp () {
        pollokshieldsLib = new Library(20);
        lote = new Book("Lote","Shola von Reinhold", "Fantasy");
        paul = new Book("Paul", "Daisy Lafarge", "Fiction");
        normalppl = new Book("Normal People", "Sally Rooney", "Fiction");
        arizona = new Book("Arizona", "Ben Roberts", "Non-fiction");
        signs = new Book("Signs", "Carolyne Faulkner", "Non-fiction");
        pollokshieldsLib.addBook(lote);
        pollokshieldsLib.addBook(paul);
        pollokshieldsLib.addBook(normalppl);
        pollokshieldsLib.addBook(arizona);
    }
    @Test
    public void canGetTotalBooks () {
        assertEquals(4, pollokshieldsLib.getTotalBooks());
    }
    @Test
    public void canAddBook () {
        pollokshieldsLib.addBook(signs);
        assertEquals(5, pollokshieldsLib.getTotalBooks());
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
    @Test
    public void cantLendBookNotInCollection () {
        pollokshieldsLib.lend(signs);
        assertTrue(lote.getAvailable());
    }
    @Test
    public void canLendBookInCollection () {
        pollokshieldsLib.addBook(lote);
        pollokshieldsLib.lend(lote);
        assertFalse(lote.getAvailable());
    }
    @Test
    public void canAcceptReturn () {
        pollokshieldsLib.lend(lote);
        pollokshieldsLib.acceptReturn(lote);
        assertTrue(lote.getAvailable());
    }
    @Test
    public void canGetGenreBreakdown () {
        HashMap<String, Integer> genrebreakdown = pollokshieldsLib.getGenreBreakdown();
        int output = genrebreakdown.get("Fiction");
        System.out.println(genrebreakdown);
        assertEquals(2, output);
    }
}
