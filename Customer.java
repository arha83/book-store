import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer extends User {
    ArrayList<Book> cart;
    // constructor method
    public Customer(String username, String password, String email){
        super(username, password, email, false);
        cart= new ArrayList<>();
    }

    public void purchaseBook(Book book){
        book.setStock(book.getStock()-1);
        cart.add(book);
    }

    public static ArrayList<User> loadCustomers(){
        File customerFile= new File("./customers.csv");
        String line;
        String customerData[];
        ArrayList<User> customers= new ArrayList<>();
        Customer newCustomer;
        
        Scanner scanner;
        try{
            scanner= new Scanner(customerFile);
            while(scanner.hasNextLine()){
                line= scanner.nextLine();
                customerData= line.split(",");
                newCustomer= new Customer(customerData[0], customerData[1], customerData[2]);
                customers.add(newCustomer);
            }
        } catch(FileNotFoundException e){
            System.out.println("Customer file not found!");
        }

        return customers;
    }

    public static void saveCustomers(ArrayList<User> customers){
        String line;
        try{
            FileWriter customerWriter= new FileWriter("./customers.csv");
            for(User customer: customers){
                if(customer.getClass() != Customer.class) continue;
                line= customer.getUsername() + "," + customer.getPassword() + "," + customer.getEmail() + "\n";
                customerWriter.write(line);
            }
            customerWriter.close();
        } catch(IOException e){
            System.out.println("Could not save to customers!");
        }
    }
}
