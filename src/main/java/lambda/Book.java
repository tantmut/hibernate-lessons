package lambda;

import java.util.List;

public class Book {

    private String bookName;
    private int year;
    private List<String> authours;


    public Book(String bookName, int year, List<String> authours) {
        this.bookName = bookName;
        this.year = year;
        this.authours = authours;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authours;
    }

    public void setAuthors(List<String> authours) {
        this.authours = authours;
    }
}
