/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class MasterProductCatalog {
    
    private ArrayList<Product> productList;

    public MasterProductCatalog() {
        this.productList = new ArrayList<>();
    }
    
    

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    
}
