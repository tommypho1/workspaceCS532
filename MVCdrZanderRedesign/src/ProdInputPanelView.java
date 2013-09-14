import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Data Gatherer on Product shipments and deliveries -- part of the Controller
class ProdInputPanelView extends JPanel implements ActionListener {
   JLabel deliveryLbl = new JLabel("Delivery: ");
   JLabel shipmentLbl = new JLabel("Shipment: ");
   JTextField deliveryTxt = new JTextField(5);
   JTextField shipmentTxt = new JTextField(5);
   
   ProductCntModel prodCnt;//*
   

   ProdInputPanelView(ProductCntModel prodCnt) {
       this.prodCnt = prodCnt;
       add(deliveryLbl);
       add(deliveryTxt);
       deliveryTxt.setActionCommand("deliveryTxt");
       deliveryTxt.addActionListener(new Controller (this.prodCnt));

       add(shipmentLbl);
       add(shipmentTxt);
       shipmentTxt.setActionCommand("shipmentTxt");
       shipmentTxt.addActionListener(new Controller (this.prodCnt));
   }

   public void actionPerformed(ActionEvent event) 
   {
	   
       if (event.getSource() == deliveryTxt) {
    	   String numItemsStr = deliveryTxt.getText();
           prodCnt.addProducts(Integer.parseInt(numItemsStr));
           deliveryTxt.setText("");
       }
       
       if (event.getSource() == shipmentTxt) {
    	   String numItemsStr = shipmentTxt.getText();
           prodCnt.removeProducts(Integer.parseInt(numItemsStr));
           shipmentTxt.setText("");
       }
       
   }

}
