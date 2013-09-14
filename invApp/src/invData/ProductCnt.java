package invData;

public class ProductCnt {
     private String name;
     private int id;
     private int numItems;
     private boolean onOrder = false;
     private SupplierEntry primarySupplier;
     private SupplierEntry secondarySupplier;

     public ProductCnt(String name, int id, int numItems) {
         this.name = name;
         this.id = id;
         this.numItems = numItems;
         primarySupplier = null;
         secondarySupplier = null;
     }

     public int getId() { return id; }
     public String getName() { return name; }
     public int getNumItems() { return numItems; }
     public boolean isOnOrder() { return onOrder; }
     public void setOnOrder(boolean orderVal) { onOrder = orderVal; }

     public SupplierEntry getPriSupplierEntry() { return primarySupplier; }
     public SupplierEntry getSecSupplierEntry() { return secondarySupplier; }

     public void setPriSupplierEntry(SupplierEntry supEnt) {
          primarySupplier = supEnt;
     }

     public void setSecSupplierEntry(SupplierEntry supEnt) {
          secondarySupplier = supEnt;
     }
}