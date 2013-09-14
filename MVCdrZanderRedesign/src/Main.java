import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main{

    public static void main(String args[]) {
      JFrame frame = new JFrame();
      ProductCntModel prodCnt = new ProductCntModel("Toasters", 5);
      ProdInputPanelView prodInput = new ProdInputPanelView(prodCnt);
      ProductStatusPanelView prodStatus = new ProductStatusPanelView(prodCnt);
      frame.setLayout(new BorderLayout());
      frame.add(prodInput,"North");
      frame.add(prodStatus,"Center");
      frame.setTitle("Product In Stock");
      frame.setSize(500,200); 
      frame.setVisible(true);
   }

}

