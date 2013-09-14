import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/** Display important inventory metrics */
public class InvMetricsPanel extends JPanel implements Observer{
      private JTextField avgTransTxtField = new JTextField(5);
      private JLabel avgTransLbl = new JLabel("Average Transaction Size: ");

      private JTextField baseLineTxtField = new JTextField(5);
      private JLabel baseLineDiffLbl = new JLabel("Distance From Baseline: ");
      private JTextField baseLineColorIndicator = new JTextField(3);

      private JPanel avgTransPanel = new JPanel();
      private JPanel baseLinePanel = new JPanel();
      private JPanel topPanel = new JPanel();
      private GridLayout topLayoutMgr = new GridLayout(2, 1);
      private static final int VERTICAL_SPACING = 20;
      
      private ProductCnt prodCnt;

      public InvMetricsPanel(ProductCnt prodData) {  
             prodCnt = prodData;
             prodCnt.addObserver(this);
             /* Configure our top level panel */
             topLayoutMgr.setVgap(VERTICAL_SPACING);
             topPanel.setLayout(topLayoutMgr);
             add(topPanel);

             /* Configure the "Average Transaction Size" panel and then add it to the top panel */
             avgTransTxtField.setEditable(false);
             avgTransTxtField.setHorizontalAlignment(JTextField.RIGHT); 
             avgTransTxtField.setText("0");
             avgTransPanel.add(avgTransLbl);
             avgTransPanel.add(avgTransTxtField);
             topPanel.add(avgTransPanel);

             /* Configure the "Baseline Information" panel and then add it to the top panel */
             baseLineTxtField.setEditable(false);
             baseLinePanel.add(baseLineDiffLbl);
             baseLinePanel.add(baseLineTxtField);
             baseLineColorIndicator.setEditable(false);
             baseLineColorIndicator.setBackground(Color.GREEN);
             baseLinePanel.add(baseLineColorIndicator);
             topPanel.add(baseLinePanel);
      }
      
      public void update(Observable obs, Object actionObj) {
          ProductCntAction action;

          if (obs == prodCnt) {
        	  
        	  action = (ProductCntAction) actionObj;
        	  Integer diff=prodCnt.getNumItems()-prodCnt.getBaseLine();
         	
         	  baseLineTxtField.setText(diff.toString());
              // This is the observable guy we are interested in
              if (((double) Math.abs(diff)/prodCnt.getBaseLine())>0.25)
              {
            	  baseLineColorIndicator.setBackground(Color.RED);
              }
              else
              {
            	  baseLineColorIndicator.setBackground(Color.GREEN);
              }
              Integer Avg=prodCnt.getTotal_trans()/prodCnt.getTime_trans();
              avgTransTxtField.setText(Avg.toString());
          }
      }
}

