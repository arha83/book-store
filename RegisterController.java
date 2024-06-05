import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    RegisterView registerView;
    ArrayList<User> users;

    public RegisterController(){
        this.registerView= new RegisterView();

        ArrayList<User> customers= Customer.loadCustomers();
        ArrayList<User> admins= Admin.loadAdmins();
        users= new ArrayList<>();
        users.addAll(customers);
        users.addAll(admins);

        this.registerView.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.registerView.loginButton){ // login button pressed
            // close the register window and open the login window
            registerView.dispose();
            new LoginController();
        }else if(e.getSource() == this.registerView.registerButton){ // register button pressed
            String username= this.registerView.usernameTextField.getText();
            String password= this.registerView.passwordTextField.getText();
            String email= this.registerView.emailTextField.getText();
            Customer customer= new Customer(username, password, email);
            // add new customer to list and save it
            users.add(customer);
            Customer.saveCustomers(users);
            // close the register window and open the book store, 
            this.registerView.dispose();
            new BookStoreController(customer);
        }
    }
}
