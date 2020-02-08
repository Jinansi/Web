/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.order.OrderItem;

/**
 *
 * @author Gunjan
 */
public class ProductOrderWorkRequest extends WorkRequest {
    
    private String ReferenceNo;
    private OrderItem orderItem;

    public ProductOrderWorkRequest(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public String getReferenceNo() {
        return ReferenceNo;
    }

    public void setReferenceNo(String ReferenceNo) {
        this.ReferenceNo = ReferenceNo;
    }

    
    @Override
    public String toString() {
        return orderItem.getProduct().getName();
    }

    


    
    
}
