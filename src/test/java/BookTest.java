import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookTest {
    Book book;
    @Before
    public void setUp () {
        book = new Book("Lote", "Shola von Reinhold", "Fantasy");
    }
    @Test
    public void canGetTitle () {
        assertEquals("Lote", book.getTitle());
    }
    @Test
    public void canToggleAvailable () {
        book.toggleAvailable();
        assertFalse(book.getAvailable());
    }

}
