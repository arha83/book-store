import java.util.ArrayList;

public class BookStore {
    // properties
    ArrayList<Book> books;

    // constructor methods
    public BookStore(ArrayList<Book> books){
        this.books= books;
    }
    public BookStore(){
        books= Book.loadBooks();
    }
    // setter methods
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    // getter methods
    public ArrayList<Book> getBooks() {
        return books;
    }
    // other methods
    public void addBook(Book book){
        books.add(book);
    }
    public void addBooks(ArrayList<Book> books){
        this.books.addAll(books);
    }
}
