import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

}
