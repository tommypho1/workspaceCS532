import java.awt.*;
import javax.swing.*;

public class InventoryGui {

    public static void main(String args[]) {
       ProductCnt prodCnt;
       InvViewerPanel invPanel;
       InvViewerFrame invFrame;
       InvViewerFrame invFrame_MP;
       InvMetricsPanel invMetricPanel;
       //  Instantiate our data structure
       //  Normally we would read it in from a file or database.  For testing, just hardcode it.
       prodCnt = new ProductCnt("Toasters", 5);
       prodCnt.setBaseLine(20);

       invPanel = new InvViewerPanel(prodCnt);
       invFrame = new InvViewerFrame(invPanel);
       invMetricPanel = new InvMetricsPanel(prodCnt);
       prodCnt.addProducts(0);
       invFrame_MP = new InvViewerFrame(invMetricPanel);
       
       invFrame.setVisible(true);
       invFrame_MP.setVisible(true);
   }

}
