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
	  ObjectUsedToCommunication objectUsedToSend;

      numItems = numItems + numProds;
      objectUsedToSend = new ObjectUsedToCommunication("DELIVERY", numProds);
	  setChanged();
	  notifyObservers(objectUsedToSend);
   }

   public void removeProducts(int numProds) { 
	  ObjectUsedToCommunication objectUsedToSend;

      numItems = numItems - numProds;
      objectUsedToSend = new ObjectUsedToCommunication("SHIPMENT", numProds);
	  setChanged();
	  notifyObservers(objectUsedToSend);
   }
}

class ObjectUsedToCommunication { 

	   private String action;
	   private int numProds;

	   ObjectUsedToCommunication(String action, int numProds) {
	      this.action = action;
		  this.numProds = numProds;
	   }

	   public boolean isShipment() { return action == "SHIPMENT"; }
	   public boolean isDelivery() { return action == "DELIVERY"; }
	   public int getNumProds() { return numProds; }
	}

