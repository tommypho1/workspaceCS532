import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

// Our View which is an Observer
class ProductStatusPanelView extends JPanel implements Observer {
      JLabel prodCntLabel, lastActionLabel;
      String cntTitle;
      String actionTitle;
      
      ProductCntModel prodCnt;

      ProductStatusPanelView(ProductCntModel counter) {  
          prodCnt = counter;
          prodCnt.addObserver(this);
          setLayout(new GridLayout(2,1));

         cntTitle = prodCnt.getName() + " In Stock: ";
         prodCntLabel = new JLabel(cntTitle + prodCnt.getNumItems(),JLabel.CENTER);
         add(prodCntLabel);

         actionTitle = "Last update: ";
         lastActionLabel = new JLabel(" ", JLabel.CENTER);
         add(lastActionLabel);
      }

      public void update(Observable obs, Object actionObj) {
          ProductCntAction action;

          if (obs == prodCnt) {
              // This is the observable guy we are interested in
              updateCnt();
              action = (ProductCntAction) actionObj;
              updateLastAction(action);
          }
      }

      private void updateCnt() {
          prodCntLabel.setText(cntTitle + prodCnt.getNumItems());
      }

      private void updateLastAction(ProductCntAction action) {
          if (action.isDelivery()) {
              lastActionLabel.setText(action.getNumItems() + " products delivered");
          } else {
              lastActionLabel.setText(action.getNumItems() + " products shipped");
          }
      }
}

