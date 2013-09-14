package invGui;
import invData.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddNewProductPanel extends JPanel implements ActionListener {
     private JLabel productLbl = new JLabel("Product Id");
     private JTextField productTxtField = new JTextField(8);
     private JButton addBtn = new JButton("Add");
     private ProductSet productSet;

     public AddNewProductPanel(ProductSet productSet) {
          this.productSet = productSet;
          add(productLbl);
          add(productTxtField);
          add(addBtn);
          addBtn.addActionListener(this);
     }

     public void actionPerformed(ActionEvent evt) {
          /* To Do: 
               1.  When a user clicks the Add button, add a row for that product to the table 
               2.  If the product id is bad, pop up a dialog box indicating a bad product id
               3.  If the product id is already in the table, don't add it again
          */ 
    	 int resultAction = productSet.addProduct(Integer.parseInt(productTxtField.getText()));
    	// UNKNOWN_PRODUCT_ID = 1;
    	 if (resultAction==1)
    		 JOptionPane.showMessageDialog(this, "A bad product id.");
    	 
     }
}