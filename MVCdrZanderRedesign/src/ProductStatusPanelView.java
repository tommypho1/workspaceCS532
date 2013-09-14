import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

// Our View which is an Observer
class ProductStatusPanelView extends JPanel implements Observer {
      JLabel prodCntLabel, lastActionLabel;
      String cntTitle;
      String objectRecievedTitle;
      
      ProductCntModel prodCnt;//*

      ProductStatusPanelView(ProductCntModel counter) {  
          prodCnt = counter;
          prodCnt.addObserver(this);//*
          setLayout(new GridLayout(2,1));

         cntTitle = prodCnt.getName() + " In Stock: ";
         prodCntLabel = new JLabel(cntTitle + prodCnt.getNumItems(),JLabel.CENTER);
         add(prodCntLabel);
         
         lastActionLabel = new JLabel(" ", JLabel.CENTER);
         add(lastActionLabel);

      }

      public void update(Observable obs, Object objectRecievedObj) {
          ObjectUsedToCommunication objectRecieved;

          if (obs == prodCnt) {
              // This is the observable guy we are interested in
        	  prodCntLabel.setText(cntTitle + prodCnt.getNumItems());
        	  
              objectRecieved = (ObjectUsedToCommunication) objectRecievedObj;
              if (objectRecieved.isDelivery()) {
            	  lastActionLabel.setText(objectRecieved.getNumProds() + " products delivered");
              } else {
            	  lastActionLabel.setText(objectRecieved.getNumProds() + " products shipped");
              }
          }
      }

}

