import java.util.Observable;

// Our Model which is Observable
class ProductCntModel extends Observable { 
   private String name;
   private int numItems;

   ProductCntModel(String name, int numItems) {
      this.name = name;
      this.numItems = numItems;
   }

   public String getName() { return name; }
   public int getNumItems() { return numItems; }

   public void addProducts(int numProds) { 
      ProductCntAction action;

      numItems = numItems + numProds;
	  action = new ProductCntAction(ProductCntAction.DELIVERY, numProds);
	  setChanged();
	  notifyObservers(action);
   }

   public void removeProducts(int numProds) { 
      ProductCntAction action;

      numItems = numItems - numProds;
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

