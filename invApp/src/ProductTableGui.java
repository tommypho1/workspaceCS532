import invData.*;
import invGui.*;
import invServices.*;

import java.awt.*;
import javax.swing.*;


public class ProductTableGui {
    public static void main(String[] args) {
         JFrame topFrame;
         Inventory inventory;
         ProductTablePanel prodTblPanel;

         inventory = InventoryService.readInvFromDb();

         prodTblPanel = new ProductTablePanel(inventory);
         topFrame = new JFrame();
         topFrame.setSize(600,200);
         topFrame.setTitle("Product Viewer");
         topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         topFrame.add(prodTblPanel);
         topFrame.setVisible(true);
         
    }
}

