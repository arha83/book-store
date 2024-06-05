import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Book {
    // properties
    private String title;
    private String author;
    private String publisher;
    private String category;
    private int price;
    private int pages;
    private int stock;
    // constructor methods
    public Book(String title, String author, String publisher, String category, int price, int pages, int stock){
        this.title= title;
        this.author= author;
        this.publisher= publisher;
        this.category= category;
        this.price= price;
        this.pages= pages;
        this.stock= stock;
    }
    // setter methods
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    // getter methods
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }
    public int getPages() {
        return pages;
    }
    public int getPrice() {
        return price;
    }
    public String getPublisher() {
        return publisher;
    }public int getStock() {
        return stock;
    }
    public String getTitle() {
        return title;
    }
    // file io methods
    public static ArrayList<Book> loadBooks(){
        File bookFile= new File("./books.csv");
        String line;
        String bookData[];
        ArrayList<Book> books= new ArrayList<>();
        Book newBook;
        
        Scanner scanner;
        try{
            scanner= new Scanner(bookFile);
            while(scanner.hasNextLine()){
                line= scanner.nextLine();
                bookData= line.split(",");
                newBook= new Book(bookData[0], bookData[1], bookData[2], bookData[3], Integer.parseInt(bookData[4]), Integer.parseInt(bookData[5]), Integer.parseInt(bookData[6]));
                books.add(newBook);
            }
        } catch(FileNotFoundException e){
            System.out.println("Customer file not found!");
        }

        return books;
    }

    public static void saveBooks(ArrayList<Book> books){
        String line;
        try{
            FileWriter bookWriter= new FileWriter("./books.csv");
            for(Book book : books){
                line= book.getTitle() + "," + book.getAuthor() + "," + book.getPublisher() + "," + book.getCategory();
                line+= "," + book.getPrice() + "," + book.getPages() + "," + book.getStock() + "\n";
                bookWriter.write(line);
            }
            bookWriter.close();
        } catch(IOException e){
            System.out.println("Could not save to customers!");
        }
    }
}
