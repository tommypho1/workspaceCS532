import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

// Demonstrate the Observable class and the Observer interface

// Our Model which is Observable
class ProductCnt extends Observable { 
   private String name;
   private int numItems;
   private int baseLine;
   private  int time_trans=0;	//number of transactions
   private  int total_trans=0;	//total items of all transactions
   
   ProductCnt(String name, int numItems) {
      this.name = name;
      this.numItems = numItems;
   }

   public String getName() { return name; }
   public int getNumItems() { return numItems; }
   
   public int getBaseLine() { return baseLine; }
   public int getTime_trans() { return time_trans;}
   public int getTotal_trans() { return total_trans;}
   
   public void setBaseLine(int newBaseLine) { 
       baseLine = newBaseLine;
   }

   public void addProducts(int numProds) { 
      ProductCntAction action;

      numItems = numItems + numProds;
      total_trans=total_trans+numProds;
      time_trans++;
	  action = new ProductCntAction(ProductCntAction.DELIVERY, numProds);
	  
	  setChanged();
	  notifyObservers(action);
   }

   public void removeProducts(int numProds) { 
      ProductCntAction action;

      numItems = numItems - numProds;
      total_trans=total_trans+numProds;
      time_trans++;
	  action = new ProductCntAction(ProductCntAction.SHIPMENT, numProds);
	  setChanged();
	  notifyObservers(action);
   }
}


class ProductCntAction { 
   final static public char SHIPMENT = 's';
   final static public char DELIVERY = 'd';
   private char action;
   private int numItems;

   ProductCntAction(char action, int numItems) {
      this.action = action;
	  this.numItems = numItems;
   }

   public boolean isShipment() { return action == SHIPMENT; }
   public boolean isDelivery() { return action == DELIVERY; }
   public int getNumItems() { return numItems; }
}


// Our View which is an Observer
class ProductStatusPanel extends JPanel implements Observer {
      JLabel prodCntLabel, lastActionLabel;
      ProductCnt prodCnt;
      String cntTitle;
      String actionTitle;

      ProductStatusPanel(ProductCnt counter) {  
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


// Data Gatherer on Product shipments and deliveries -- part of the Controller
class ProdInputPanel extends JPanel implements ActionListener {
      JLabel deliveryLbl = new JLabel("Delivery: ");
      JLabel shipmentLbl = new JLabel("Shipment: ");
      JTextField deliveryTxt = new JTextField(5);
      JTextField shipmentTxt = new JTextField(5);
      ProductCnt prodCnt;
      

      ProdInputPanel(ProductCnt prodCnt) {
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


// Top-Level Controller
class InvViewerPanel extends JPanel {
      ProdInputPanel prodInput;
      ProductStatusPanel prodStatus;

      InvViewerPanel(ProductCnt prodCnt) {
         setLayout(new BorderLayout());
         prodInput = new ProdInputPanel(prodCnt);
         add(prodInput,"North");
         prodStatus = new ProductStatusPanel(prodCnt);
         add(prodStatus,"Center");
      }

}


class InvViewerFrame extends JFrame {
   public InvViewerFrame(JPanel topPanel) {
      Container topContainer = getContentPane();

      WindowListener exitListener = new FrameTerminator();
      addWindowListener(exitListener);
      setTitle("Product In Stock");
      setSize(500,200); 
      topContainer.add(topPanel);
   }

   class FrameTerminator extends WindowAdapter {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
   }

}


public class ObservableInv{

    public static void main(String args[]) {
      ProductCnt prodCnt;
      InvViewerPanel invPanel;
      InvViewerFrame invFrame;
      
      //  Instantiate our data structure
      //   Normally we would read it in from a file or database
      prodCnt = new ProductCnt("Toasters", 5);
      prodCnt.setBaseLine(20);
      invPanel = new InvViewerPanel(prodCnt);
      invFrame = new InvViewerFrame(invPanel);
      invFrame.setVisible(true);
   }

}
