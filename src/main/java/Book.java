public class Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }
    public String getTitle() {
        return title;
    }
    public boolean getAvailable () {
        return this.available;
    }

    public String getGenre() {
        return this.genre;
    }

    public void toggleAvailable() {
        this.available = !this.available;
    }
}
