import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Controller implements ActionListener {
	ProductCntModel prodCnt;
	
	public Controller(ProductCntModel prodCnt)
	{
		this.prodCnt = prodCnt;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		 if (event.getActionCommand() == "deliveryTxt") 
		 {

			JTextField deliveryTxt=(JTextField) event.getSource();
			String numItemsStr = deliveryTxt.getText();
	        prodCnt.addProducts(Integer.parseInt(numItemsStr));
	        deliveryTxt.setText("");
	     }
		 else if (event.getActionCommand() == "shipmentTxt") 
		 {
			 JTextField shipmentTxt=(JTextField) event.getSource();
	    	 String numItemsStr = shipmentTxt.getText();
	         prodCnt.removeProducts(Integer.parseInt(numItemsStr));
	         shipmentTxt.setText("");
	     }
		
	}

}
