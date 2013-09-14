package invServices;
import invData.*;

public class InventoryService {

    // Ok, we're not really reading the data from a database, but we can add that later!
    public static Inventory readInvFromDb() {
         ProductCnt prod;
         Inventory inv = new Inventory();
         SupplierEntry supEnt;

         // add some products to our inventory
         prod = new ProductCnt("Toaster", 1000, 12);
         supEnt = new SupplierEntry("Cooking Delight", 0);
         prod.setPriSupplierEntry(supEnt);
         supEnt = new SupplierEntry("Walt's Products", 0);
         prod.setSecSupplierEntry(supEnt);
         inv.addProduct(prod);

         prod = new ProductCnt("Knife Set", 4102, 3);
         prod.setOnOrder(true);
         supEnt = new SupplierEntry("Katbaum", 12);
         prod.setPriSupplierEntry(supEnt);
         supEnt = new SupplierEntry("Mitch Steel", 0);
         prod.setSecSupplierEntry(supEnt);
         inv.addProduct(prod);

         prod = new ProductCnt("Blender", 1001, 9);
         supEnt = new SupplierEntry("Z Industries", 0);
         prod.setPriSupplierEntry(supEnt);
         supEnt = new SupplierEntry("Walt's Products", 0);
         prod.setSecSupplierEntry(supEnt);
         inv.addProduct(prod);

         prod = new ProductCnt("Mixer", 1002, 45);
         prod.setOnOrder(true);
         supEnt = new SupplierEntry("Z Industries", 10);
         prod.setPriSupplierEntry(supEnt);
         supEnt = new SupplierEntry("Walt's Products", 2);
         prod.setSecSupplierEntry(supEnt);
         inv.addProduct(prod);

         prod = new ProductCnt("Can Opener", 1008, 16);
         prod.setOnOrder(true);
         supEnt = new SupplierEntry("Z Industries", 10);
         prod.setPriSupplierEntry(supEnt);
         supEnt = new SupplierEntry("Cooking Delight", 1);
         prod.setSecSupplierEntry(supEnt);
         inv.addProduct(prod);

         prod = new ProductCnt("Silverware Set", 1010, 16);
         prod.setOnOrder(true);
         supEnt = new SupplierEntry("Coulier", 3);
         prod.setPriSupplierEntry(supEnt);
         supEnt = new SupplierEntry("Restaurant Supply", 0);
         prod.setSecSupplierEntry(supEnt);
         inv.addProduct(prod);

         return inv;
    }
}

