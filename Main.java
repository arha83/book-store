
public class Main{
    public static void main(String[] args) {


        new PurchaseController(Customer.loadCustomers().get(1), new BookStore(Book.loadBooks()));

    }
}