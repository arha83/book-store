import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PurchaseView extends JFrame {
    JButton buyButton;
    JButton backButton;

    public PurchaseView(){
        super("Purchase");
        this.setSize(300, 220);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel purchasePanel= new JPanel();
        purchasePanel.setLayout(new BoxLayout(purchasePanel, BoxLayout.Y_AXIS));

        JLabel purchaseLabel= new JLabel("Purchase");
        JTextField nameTextField= new JTextField("full name");
        JTextField addressTextField= new JTextField("full address");
        JTextField cardInfoTextField= new JTextField("card Info");
        buyButton= new JButton("Buy");
        backButton= new JButton("Back");

        purchaseLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        nameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        addressTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        cardInfoTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        buyButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        backButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        purchasePanel.add(purchaseLabel);
        purchasePanel.add(Box.createVerticalStrut(5));
        purchasePanel.add(nameTextField);
        purchasePanel.add(Box.createVerticalStrut(5));
        purchasePanel.add(addressTextField);
        purchasePanel.add(Box.createVerticalStrut(5));
        purchasePanel.add(cardInfoTextField);
        purchasePanel.add(Box.createVerticalStrut(5));
        purchasePanel.add(buyButton);
        purchasePanel.add(Box.createVerticalStrut(5));
        purchasePanel.add(backButton);

        purchasePanel.setBounds(10,0,265,220);
        this.add(purchasePanel);
        this.setVisible(true);
    }

    public void setActionListener(ActionListener actionListener){
        this.buyButton.addActionListener(actionListener);
        this.backButton.addActionListener(actionListener);
    }
}
