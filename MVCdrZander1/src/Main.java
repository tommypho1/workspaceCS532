import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main{

    public static void main(String args[]) {
      ProductCntModel prodCnt;
      InvViewerPanel invPanel;
      InvViewerFrame invFrame;
      
      //  Instantiate our data structure
      //   Normally we would read it in from a file or database
      prodCnt = new ProductCntModel("Toasters", 5);

      invPanel = new InvViewerPanel(prodCnt);
      invFrame = new InvViewerFrame(invPanel);
      invFrame.setVisible(true);
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