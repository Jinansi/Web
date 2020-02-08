/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

import business.Enterprise.SellerEnterprise;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class OrderDirectory {
    private ArrayList<Order> orderlist;

    public OrderDirectory() {
        orderlist = new ArrayList<>();
    }

    public ArrayList<Order> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList<Order> orderlist) {
        this.orderlist = orderlist;
    }

    public double calculateTotalCommissiononEachOrder(){
        double total = 0.0;
        for(Order order :this.getOrderlist()){
            total += (order.calculateCommission());
        }
        return total;
    }
    
    public double calulatecommissiononbasisofseller(SellerEnterprise enterprise){
        double total = 0.0;
        for(Order order :this.getOrderlist()){
            total += (order.calulatecommissiononbasisofseller(enterprise));
        }
        return total;
    }
}
