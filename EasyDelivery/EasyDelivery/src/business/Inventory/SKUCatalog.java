/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunjan
 */
public class SKUCatalog {
    
    private List<SKU> skuList;
    
    public SKUCatalog(){
        skuList = new ArrayList<SKU>();
    }

    public List<SKU> getSkuList() {
        return skuList;
    }

    public void addSKU(SKU sku){
        skuList.add(sku);
    }
    
    public SKU getSKU(Product product){
        for(SKU sku:getSkuList()){
            if(sku.getProduct().equals(product)){
                return sku;
            }
        }
        return null;
    }
    
    public boolean isSKUPresent(SKU givenSKU){
        for(SKU sku:getSkuList()){
            if(sku.getSkuID() == givenSKU.getSkuID()){
                return true;
            }
        }
            return false;
    }

    public boolean fulfillorder(Product product , int quantity){
        for(SKU sku : skuList){
            if(sku.getProduct().equals(product)&& sku.getQuantity() >= quantity){
                sku.setQuantity(sku.getQuantity()-quantity);
                return true;
            }  
        }
        return false;
    }
    
    public void incrementQuantity(Product product, int quantity){
        for(SKU sku:skuList){
            if(product==sku.getProduct()){
                sku.setQuantity(sku.getQuantity()+quantity);
            }
        }
    }
    
}
