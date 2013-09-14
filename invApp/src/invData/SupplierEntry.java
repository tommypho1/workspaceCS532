package invData;

public class SupplierEntry {
     private String name;
     private int numItemsOrdered;

     public SupplierEntry(String name, int numItemsOrdered) {
         this.name = name;
         this.numItemsOrdered = numItemsOrdered;
     }

     public String getName() { return name; }
     public int getNumItemsOrdered() { return numItemsOrdered; }
}