import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    LoginView loginView;
    ArrayList<User> users;

    public LoginController(){
        this.loginView= new LoginView();

        ArrayList<User> customers= Customer.loadCustomers();
        ArrayList<User> admins= Admin.loadAdmins();
        users= new ArrayList<>();
        users.addAll(customers);
        users.addAll(admins);

        this.loginView.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.loginView.registerButton){ // register button pressed
            // close the login window and open the register window
            this.loginView.dispose();
            new RegisterController();
        }else if(e.getSource() == this.loginView.loginButton){ // login button pressed
            String username= this.loginView.usernameTextField.getText();
            String password= this.loginView.passwordTextField.getText();
            for(User user : this.users){
                if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                    // close the login window, open the book store, break the loop
                    this.loginView.dispose();
                    new BookStoreController(user);
                    return;
                }    
            }
            JOptionPane.showMessageDialog(loginView, "wrong username/password combination", "wrong", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
