/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

import business.Enterprise.SellerEnterprise;
import business.Inventory.SKUHolder;
import business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import userInterface.Customer.ShoppingCartJPanel;

/**
 *
 * @author Gunjan
 */
public class Order {
    
    private int orderNo;
    private ArrayList<OrderItem> orderItemList;
    private static int counter = 100;
    private UserAccount customerwhodidtheorder;
    private double totalPrice;
    private Date date;

    //constructor
    public Order() {
        orderItemList = new ArrayList<>();
        orderNo = counter++;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public UserAccount getCustomerwhodidtheorder() {
        return customerwhodidtheorder;
    }

    public void setCustomerwhodidtheorder(UserAccount customerwhodidtheorder) {
        this.customerwhodidtheorder = customerwhodidtheorder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public OrderItem addNewOrderItem(SKUHolder skuHolder, int quantity, double productPrice) {
        OrderItem newOrderItem = new OrderItem(skuHolder, quantity, productPrice);
        orderItemList.add(newOrderItem);
        return newOrderItem;
    }
    
    public void removeOrderItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }
    
    
    public double calculateCommission(){
        double totalsum = 0.0;
        for(OrderItem oi : this.getOrderItemList()){
            totalsum += (oi.getTotalPrice()*0.2);
        }
        return totalsum;
    }
    
    public double calulatecommissiononbasisofseller(SellerEnterprise enterprise){
       double totalsum = 0.0; 
       for(OrderItem orderit :this.getOrderItemList()){
           if(orderit.getSkuHolder().seller.equals(enterprise)){
              totalsum+= (orderit.getTotalPrice()*0.2); 
           }
       }
       return totalsum;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.orderNo);
    }
}
