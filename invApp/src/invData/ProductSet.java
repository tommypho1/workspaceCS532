package invData;

import java.util.*;

public class ProductSet extends Observable {
    private ArrayList<ProductCnt> products;
    private Inventory masterProdSet;
    public static final int OPERATION_SUCCESSFUL = 0;
    public static final int UNKNOWN_PRODUCT_ID = 1;
    public static final int DUPLICATE_PRODUCT_ID = 2;

    public ProductSet(Inventory inv) {
        masterProdSet = inv;
        products = new ArrayList<ProductCnt>();
    }

    public int addProduct(int prodId) {
        ProductCnt prodCnt;
        int i, numProds;

        numProds = products.size();
        for (i=0; i<numProds; i++) {
             prodCnt = products.get(i);
             if (prodCnt.getId() == prodId) {
                 return DUPLICATE_PRODUCT_ID;
             }
        }
        
        prodCnt = masterProdSet.getProductFromId(prodId);
        if (prodCnt == null) {
             return UNKNOWN_PRODUCT_ID;
        }

        products.add(prodCnt);
        setChanged();
        notifyObservers();
        return OPERATION_SUCCESSFUL;
    }

    public void removeAtIdx(int idx) {
        products.remove(idx);
        
    }

    public int size() {
        return products.size();
    }

    public ProductCnt get(int idx) {
        return products.get(idx);
    }
    
    public int removeProduct(int prodId) {
        ProductCnt prodCnt;
        int i, numProds;

        numProds = products.size();
        for (i=0; i<numProds; i++) {
             prodCnt = products.get(i);
             if (prodCnt.getId() == prodId) {
            	 products.remove(i);
                 return OPERATION_SUCCESSFUL;
             }
        }
        
     //   setChanged();
     //   notifyObservers();
        return UNKNOWN_PRODUCT_ID;
    }
}
 