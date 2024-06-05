import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookStoreView extends JFrame {
    private BookStore bookStore;
    private User user;

    protected ArrayList<JButton> addToCartButtons;
    protected ArrayList<JButton> removeFromCartButtons;
    protected JButton logoutButton;
    protected JButton purchaseButton;
    protected JButton addBookButton;
    protected JButton signUpButton;
    protected JButton signInButton;
    protected JTextField bookTitleTextField;
    protected JTextField bookAuthorTextField;
    protected JTextField bookPublisherTextField;
    protected JTextField bookCategoryTextField;
    protected JTextField bookPriceTextField;
    protected JTextField bookPagesTextField;
    protected JTextField bookStockTextField;

    public BookStoreView(BookStore bookStore, User user){
        super("Book store");
        // view properties
        this.bookStore= bookStore;
        this.user= user;
        // frame layout
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        // books list
        addToCartButtons= new ArrayList<>();
        removeFromCartButtons= new ArrayList<>();

        JPanel booksListPanel= new JPanel();
        booksListPanel.setLayout(new BoxLayout(booksListPanel, BoxLayout.Y_AXIS));
        booksListPanel.setAlignmentX(0.0f);
        for(Book book : bookStore.getBooks()){
            String bookTitle= book.getTitle() + " by " + book.getAuthor() + "    Pages: " + book.getPages() + "          ";
            String bookDescription= "Category: " + book.getCategory() + "    Publisher: " + book.getPublisher() + "          ";

            JPanel bookRowPanel= new JPanel();
            JLabel bookTitleLabel= new JLabel(bookTitle);
            JLabel bookDescriptionLabel= new JLabel(bookDescription);
            JButton bookButton= new JButton("$" + book.getPrice());

            bookRowPanel.setLayout(new BoxLayout(bookRowPanel, BoxLayout.X_AXIS));
            bookRowPanel.setAlignmentX(0.0f);
            bookRowPanel.add(bookTitleLabel);
            bookRowPanel.add(bookButton);

            booksListPanel.add(bookRowPanel);
            booksListPanel.add(bookDescriptionLabel);
            booksListPanel.add(Box.createVerticalStrut(15));

            addToCartButtons.add(bookButton);
        }
        JScrollPane booksListPane= new JScrollPane(booksListPanel);
        booksListPane.setBounds(10,20,500,520);
        // user info
        JPanel userControlPanel= new JPanel();
        userControlPanel.setLayout(new BoxLayout(userControlPanel, BoxLayout.Y_AXIS));
        userControlPanel.setAlignmentY(0.0f);

        if(user != null){ // logged in user
            JLabel usernameLabel= new JLabel("Username: " + user.getUsername());
            JLabel isAdminLabel= new JLabel(user.isAdmin() ? "ADMIN" : "");

            userControlPanel.add(usernameLabel);
            userControlPanel.add(isAdminLabel);

            if(user.getClass() == Customer.class){ // user is a customer
                JPanel cartPanel= new JPanel();
                cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
                cartPanel.setAlignmentX(0.0f);

                int totalPrice= 0;
                for(Book book : ((Customer) user).cart){
                    JPanel cartRowPanel= new JPanel();
                    cartRowPanel.setLayout(new BoxLayout(cartRowPanel, BoxLayout.X_AXIS));
                    cartRowPanel.setAlignmentX(0.0f);

                    JLabel bookCartLabel= new JLabel(book.getTitle() + "   $" + book.getPrice() + "   ");
                    JButton removeBookButton= new JButton("Remove");

                    cartRowPanel.add(bookCartLabel);
                    cartRowPanel.add(removeBookButton);

                    cartPanel.add(cartRowPanel);
                    cartPanel.add(Box.createVerticalStrut(5));
                    totalPrice+= book.getPrice();
                    removeFromCartButtons.add(removeBookButton);
                }

                JScrollPane cartPane= new JScrollPane(cartPanel);
                cartPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 400));

                JLabel totalPriceLabel= new JLabel("Total price: $" + totalPrice);
                purchaseButton= new JButton("Purchase");
                // purchaseButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, purchaseButton.getHeight()));

                userControlPanel.add(cartPane);
                userControlPanel.add(Box.createVerticalStrut(20));
                userControlPanel.add(totalPriceLabel);
                userControlPanel.add(Box.createVerticalStrut(20));
                userControlPanel.add(purchaseButton);
            }else{ // user is an admin
                JLabel addBookLabel= new JLabel("Add book");
                bookTitleTextField= new JTextField("Book title");
                bookAuthorTextField= new JTextField("Book author");
                bookPublisherTextField= new JTextField("Book publisher");
                bookCategoryTextField= new JTextField("Book category");
                bookPriceTextField= new JTextField("Book price");
                bookPagesTextField= new JTextField("Book pages");
                bookStockTextField= new JTextField("Book stock");
                addBookButton= new JButton("Add book");

                bookTitleTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                bookAuthorTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                bookPublisherTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                bookCategoryTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                bookPriceTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                bookPagesTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                bookStockTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

                userControlPanel.add(Box.createVerticalStrut(15));
                userControlPanel.add(addBookLabel);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookTitleTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookAuthorTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookPublisherTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookCategoryTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookPriceTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookPagesTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(bookStockTextField);
                userControlPanel.add(Box.createVerticalStrut(5));
                userControlPanel.add(addBookButton);
            }

            logoutButton= new JButton("Log-out");
    
            userControlPanel.add(Box.createVerticalStrut(5));
            userControlPanel.add(logoutButton);
        }else{ // logged out user
            signInButton= new JButton("Sign-in");
            signUpButton= new JButton("Sign-up");

            signInButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, signInButton.getPreferredSize().height));
            signUpButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, signUpButton.getPreferredSize().height));

            userControlPanel.add(signInButton);
            userControlPanel.add(Box.createVerticalStrut(10));
            userControlPanel.add(signUpButton);
        }


        userControlPanel.setBounds(530, 20, 235, 520);
        // adding panes to frame
        this.add(booksListPane);
        this.add(userControlPanel);
        // show the frame
        setVisible(true);
    }
    // action listener
    public void setActionListener(ActionListener actionListener){
        for(JButton button : this.addToCartButtons) button.addActionListener(actionListener);
        for(JButton button : this.removeFromCartButtons) button.addActionListener(actionListener);
        if(this.logoutButton != null)this.logoutButton.addActionListener(actionListener);
        if(this.purchaseButton != null) this.purchaseButton.addActionListener(actionListener);
        if(this.addBookButton != null)this.addBookButton.addActionListener(actionListener);
        if(this.signUpButton != null)this.signUpButton.addActionListener(actionListener);
        if(this.signInButton != null)this.signInButton.addActionListener(actionListener);
    }
    // getters
    public User getUser() {
        return user;
    }
    public BookStore getBookStore() {
        return bookStore;
    }
}
