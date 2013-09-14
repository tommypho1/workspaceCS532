import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Top-Level Controller
class InvViewerPanel extends JPanel {
      ProdInputPanel prodInput;
      ProductStatusPanelView prodStatus;

      InvViewerPanel(ProductCntModel prodCnt) {
         setLayout(new BorderLayout());
         prodInput = new ProdInputPanel(prodCnt);
         add(prodInput,"North");
         prodStatus = new ProductStatusPanelView(prodCnt);
         add(prodStatus,"Center");
      }

}

//Data Gatherer on Product shipments and deliveries -- part of the Controller
class ProdInputPanel extends JPanel implements ActionListener {
   JLabel deliveryLbl = new JLabel("Delivery: ");
   JLabel shipmentLbl = new JLabel("Shipment: ");
   JTextField deliveryTxt = new JTextField(5);
   JTextField shipmentTxt = new JTextField(5);
   ProductCntModel prodCnt;
   

   ProdInputPanel(ProductCntModel prodCnt) {
       this.prodCnt = prodCnt;
       add(deliveryLbl);
       add(deliveryTxt);
       deliveryTxt.addActionListener(this);

       add(shipmentLbl);
       add(shipmentTxt);
       shipmentTxt.addActionListener(this);
   }

   private void shipProduct() {
       String numItemsStr = shipmentTxt.getText();
       prodCnt.removeProducts(Integer.parseInt(numItemsStr));
   }

   private void deliverProduct() {
       String numItemsStr = deliveryTxt.getText();
       prodCnt.addProducts(Integer.parseInt(numItemsStr));
   }

   public void actionPerformed(ActionEvent event) {
       if (event.getSource() == deliveryTxt) {
           deliverProduct();
           deliveryTxt.setText("");
       } else if (event.getSource() == shipmentTxt) {
           shipProduct();
           shipmentTxt.setText("");
       }
   }

}
