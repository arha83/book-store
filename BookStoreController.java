import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStoreController implements ActionListener{
    BookStore bookStore;
    BookStoreView bookStoreView;
    User user;

    public BookStoreController(User user){
        this.bookStore= new BookStore();
        this.bookStoreView= new BookStoreView(bookStore, user);
        this.user= user;

        this.bookStoreView.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bookStoreView.signInButton){
            this.bookStoreView.dispose();
            new LoginController();
        }else if(e.getSource() == this.bookStoreView.signUpButton){
            this.bookStoreView.dispose();
            new RegisterController();
        }else if(e.getSource() == this.bookStoreView.logoutButton){
            this.user= null;
            this.bookStoreView.dispose();
            this.bookStoreView= new BookStoreView(this.bookStore, this.user);
            this.bookStoreView.setActionListener(this);
        }else if(e.getSource() == this.bookStoreView.addBookButton){
            String title= this.bookStoreView.bookTitleTextField.getText();
            String author= this.bookStoreView.bookAuthorTextField.getText();
            String category= this.bookStoreView.bookCategoryTextField.getText();
            String publisher= this.bookStoreView.bookPublisherTextField.getText();
            int price= Integer.parseInt(this.bookStoreView.bookPriceTextField.getText());
            int pages= Integer.parseInt(this.bookStoreView.bookPagesTextField.getText());
            int stock= Integer.parseInt(this.bookStoreView.bookStockTextField.getText());

            Book book= new Book(title, author, publisher, category, price, pages, stock);
            this.bookStore.addBook(book);
            Book.saveBooks(this.bookStore.getBooks());

            this.bookStoreView.dispose();
            this.bookStoreView= new BookStoreView(this.bookStore, this.user);
            this.bookStoreView.setActionListener(this);
        }else if(e.getSource() == this.bookStoreView.purchaseButton){
            this.bookStoreView.dispose();
            new PurchaseController(this.user, this.bookStore);
        }else{
            int i=0;
            for(JButton button : this.bookStoreView.addToCartButtons){
                if(e.getSource() == button && this.user != null){
                    Book chosenBook= this.bookStore.getBooks().get(i);
                    ((Customer) this.user).cart.add(chosenBook);

                    this.bookStoreView.dispose();
                    this.bookStoreView= new BookStoreView(this.bookStore, this.user);
                    this.bookStoreView.setActionListener(this);
                    return;
                }
                i++;
            }
            i=0;
            for(JButton button : this.bookStoreView.removeFromCartButtons){
                if(e.getSource() == button && this.user != null){
                    ((Customer) this.user).cart.remove(i);

                    this.bookStoreView.dispose();
                    this.bookStoreView= new BookStoreView(this.bookStore, this.user);
                    this.bookStoreView.setActionListener(this);
                    return;
                }
                i= 0;
            }
        }
    }
}
