/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Inventory.Product;
import business.Inventory.SKU;
import business.Inventory.SKUCatalog;



/**
 *
 * @author Gunjan
 */
public abstract class StockOrganization extends Organization{

    private SKUCatalog skuCatalog ;
    
    public StockOrganization(Type type, String name) {
        super(type, name);
        skuCatalog = new SKUCatalog();
    }

    public SKUCatalog getSkuCatalog() {
        return skuCatalog;
    }
    
    public boolean isSKUPresent(SKU givenSKU){
        return skuCatalog.isSKUPresent(givenSKU);
    }
    
    public SKU getSKU(Product product){
        return skuCatalog.getSKU(product);
    }
}
