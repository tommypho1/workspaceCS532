package invData;

import java.util.*;

// Our inventory is a list of products.    
public class Inventory {
     private ArrayList<ProductCnt> prodList = new ArrayList<ProductCnt>(50);

     public void addProduct(ProductCnt cnt) {
         prodList.add(cnt);
     }

     public ProductCnt getProduct(int idx) {
         ProductCnt prodCnt;

         prodCnt = prodList.get(idx);
         return(prodCnt);
     }

     public ProductCnt getProductFromId(int prodId) {
         ProductCnt prodCnt;
         int i, numProds;

         numProds = prodList.size();
         for (i=0; i<numProds; i++) {
             prodCnt = prodList.get(i);
             if (prodCnt.getId() == prodId) {
                  return prodCnt;
             }
         }

         return(null);
     }

     public int size() {
         return(prodList.size());
     }
}