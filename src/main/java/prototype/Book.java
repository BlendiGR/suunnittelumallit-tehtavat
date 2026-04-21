package prototype;

public class Book implements Prototype {
    private String author;
    private String title;
    private Genres genres;

    public Book(String author, String title, Genres genres) {
        this.author = author;
        this.title = title;
        this.genres = genres;
    }




    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Genres getGenre() { return genres; }

    @Override
    public Prototype clone() {
        return new Book(this.author, this.title, this.genres);
    }
}
