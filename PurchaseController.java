import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PurchaseController implements ActionListener{
    PurchaseView purchaseView;
    BookStore bookStore;
    User user;

    public PurchaseController(User user, BookStore bookStore){
        this.user= user;
        this.bookStore= bookStore;
        purchaseView= new PurchaseView();

        purchaseView.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.purchaseView.buyButton){ // buy button pressed
            for(Book book : ((Customer) this.user).cart){
                if(book.getStock() <= 0){
                    JOptionPane.showMessageDialog(purchaseView, "the book " + book.getTitle() + " has sold out.", "no book", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            for(Book book : ((Customer) this.user).cart){
                book.setStock(book.getStock()-1);
            }
            JOptionPane.showMessageDialog(purchaseView, "Books purchased successfully", "successful", JOptionPane.INFORMATION_MESSAGE);
            ((Customer) this.user).cart.clear();
            Book.saveBooks(bookStore.getBooks());
        }else if(e.getSource() == this.purchaseView.backButton){ // back button pressed
            this.purchaseView.dispose();
            new BookStoreController(this.user);
        }
    }
}
