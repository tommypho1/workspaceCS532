import java.awt.*;
import javax.swing.*;

public class DailyShipmentsPanel extends JPanel {
      private JTextField dailyShipTxtField = new JTextField(5);
      private JLabel dailyShipLbl = new JLabel("Today's Shipments: ");
      private ProductCnt prodCnt;
      private int shipmentTotal = 0;

      DailyShipmentsPanel(ProductCnt prodData) {  
  	     prodCnt = prodData;
             dailyShipTxtField.setEditable(false);
             add(dailyShipLbl);
             add(dailyShipTxtField);
             dailyShipTxtField.setText("0");
      }
}

