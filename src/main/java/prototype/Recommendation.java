package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books;
    }

    public String getTargetAudience() { return targetAudience; }
    public List<Book> getBooks() { return books; }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public Prototype clone() {
        List<Book> recommendationList = new ArrayList<>();
        for (Book book : books) {
            Book clonedBook = (Book) book.clone();
            recommendationList.add(clonedBook);
        }
        return new Recommendation(this.targetAudience, recommendationList);
    }
}
