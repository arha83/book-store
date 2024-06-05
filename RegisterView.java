import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame{
    protected JTextField usernameTextField;
    protected JTextField passwordTextField;
    protected JTextField emailTextField;
    protected JButton registerButton;
    protected JButton loginButton;

    public RegisterView(){
        super("Register");
        this.setSize(250, 220);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);

        JPanel loginPanel= new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel loginLabel= new JLabel("Register");
        usernameTextField= new JTextField("Username");
        emailTextField= new JTextField("Email");
        passwordTextField= new JTextField("Password");
        registerButton= new JButton("Register");
        loginButton= new JButton("Log-in");

        loginLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        usernameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        emailTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        passwordTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        registerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        loginPanel.add(loginLabel);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(usernameTextField);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(emailTextField);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(passwordTextField);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(registerButton);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(loginButton);

        loginPanel.setBounds(10, 0, 215, 220);
        this.add(loginPanel);

        this.setVisible(true);
    }
    // action listener
    public void setActionListener(ActionListener actionListener){
        emailTextField.addActionListener(actionListener);
        registerButton.addActionListener(actionListener);
        loginButton.addActionListener(actionListener);
    }
}
