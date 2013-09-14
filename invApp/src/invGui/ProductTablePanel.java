package invGui;
import invData.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;



public class ProductTablePanel extends JPanel implements ActionListener, Observer {
    private JTable invTable;      // actually displays the data (graphically)
    private JButton removeBtn = new JButton("Remove Product");
    private JPanel removeBtnPanel = new JPanel();
    private AddNewProductPanel addNewProdPanel;
    private ProductSet products;  /* This panel displays the products in this set as a table */
   // private String invData[][] = {{"Silverware", "1001", "Walt's", "3", "Z Supply", "6"}, {"Blender", "2001", "G Supply", "25", "AJs", "19"}};
    private String invData[][]= {{"","","","","","",}};
    private String tblColNames[] = {"Product", "Prod Id", "Pri Supplier", "Pri Units", "Sec Supplier", "Sec Units"};
    private DefaultTableModel invDefaultTableModel; 
    public ProductTablePanel(Inventory inv) {
         super(new BorderLayout());
         products = new ProductSet(inv);
        
         products.addProduct(1001);
         
         for (int i=0; i<products.size(); i++ )
         {
        	 ProductCnt product=products.get(i);
        	 invData[i][0]=product.getName();
        	 invData[i][1]=""+product.getId();
        	 invData[i][2]=product.getPriSupplierEntry().getName();
        	 invData[i][3]=""+product.getPriSupplierEntry().getNumItemsOrdered();
        	 invData[i][4]=product.getSecSupplierEntry().getName();
        	 invData[i][5]=""+product.getSecSupplierEntry().getNumItemsOrdered();
         }
         invDefaultTableModel = new DefaultTableModel (invData, tblColNames);
         invTable = new JTable(invDefaultTableModel);
         invTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         products.addObserver(this);
       //  invTable = new JTable(invData, tblColNames);

         // put the JTable in a JScrollPane so that if the table
         // gets to large to fit in the allocated space, scroll bars will appear
         JScrollPane scroll  = new JScrollPane(invTable); 
         scroll.setPreferredSize(new Dimension(550, 100));
         add(scroll, BorderLayout.CENTER); 

         removeBtn.addActionListener(this);
         removeBtnPanel.add(removeBtn);
         add(removeBtnPanel, BorderLayout.EAST); 

         addNewProdPanel = new AddNewProductPanel(products);
         add(addNewProdPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent evt) {
         /* To Do:  This event handler removes a row from the table */
    
    	if (invTable.getSelectedRow() >= 0)
    	{
    		int selectedRow=invTable.getSelectedRow();
    		Vector selectedRowData = (Vector) invDefaultTableModel.getDataVector().get(selectedRow);
    		//id product which will be removed out of products
    		String idProduct=(String) selectedRowData.get(1);
    		products.removeProduct(Integer.parseInt(idProduct));
    		invDefaultTableModel.removeRow(selectedRow);
    	}
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(products.size());
		
		 Object newRow[]=new Object[6];
		 ProductCnt newProduct = products.get(products.size()-1);
		 
		 newRow[0]=""+newProduct.getName();
		 newRow[1]=""+newProduct.getId();
		 newRow[2]=""+newProduct.getPriSupplierEntry().getName();
		 newRow[3]=""+newProduct.getPriSupplierEntry().getNumItemsOrdered();
		 newRow[4]=""+newProduct.getSecSupplierEntry().getName();
		 newRow[5]=""+newProduct.getSecSupplierEntry().getNumItemsOrdered();
		 invDefaultTableModel.insertRow(invDefaultTableModel.getRowCount(), newRow);
         
	}
                     
}


