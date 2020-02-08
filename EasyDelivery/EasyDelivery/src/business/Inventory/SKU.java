/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

/**
 *
 * @author Gunjan
 */
public class SKU {
    
    // data members
    private Product product;
    private int quantity;
    private int skuID ;
    private static int count = 100;

    public SKU(Product product) {
        this.skuID = count++;
        this.product = product;
    }

    public int getSkuID() {
        return skuID;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.getProduct().getName();
    }

    
}
