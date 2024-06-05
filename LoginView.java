import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    protected JTextField usernameTextField;
    protected JTextField passwordTextField;
    protected JButton loginButton;
    protected JButton registerButton;

    public LoginView(){
        super("Log-in");
        this.setSize(250, 190);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);

        JPanel loginPanel= new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel loginLabel= new JLabel("Log-in");
        usernameTextField= new JTextField("Username");
        passwordTextField= new JTextField("Password");
        loginButton= new JButton("Log-in");
        registerButton= new JButton("Register");

        loginLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        usernameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        passwordTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        registerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        loginPanel.add(loginLabel);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(usernameTextField);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(passwordTextField);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(loginButton);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(registerButton);

        loginPanel.setBounds(10, 0, 215, 190);
        this.add(loginPanel);

        this.setVisible(true);
    }
    public void setActionListener(ActionListener actionListener){
        registerButton.addActionListener(actionListener);
        loginButton.addActionListener(actionListener);
    }
}
