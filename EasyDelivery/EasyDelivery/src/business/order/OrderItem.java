/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

import business.Inventory.Product;
import business.Inventory.SKUHolder;

/**
 *
 * @author Gunjan
 */
public class OrderItem {

    private int quantity;
    private double totalPrice;
    private Product product;
    private SKUHolder skuHolder;
    private int orderItemId;
    private static int count = 1;
    private double productPrice;
    private double productTax = 0.06;
    private Status status;
    
    public enum Status {

        InProcess("In Process"),
        Dispatched("Dispatched"),
        Delivered("Delivered");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public OrderItem(SKUHolder skuHolder, int quantity, double productPrice) {
        this.orderItemId = count++;
        this.skuHolder = skuHolder;
        this.product = skuHolder.sku.getProduct();
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = productPrice * quantity;
    }

    public SKUHolder getSkuHolder() {
        return skuHolder;
    }

    public void setSkuHolder(SKUHolder skuHolder) {
        this.skuHolder = skuHolder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductTax() {
        return productTax;
    }

    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }

    public double getTax() {
        return productTax * totalPrice;
    }

    public double gettotalWithTax() {
        return totalPrice + getTax();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(getOrderItemId());
    }

}
