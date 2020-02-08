/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.Customer.CustomerAccount;
import business.order.OrderItem;

/**
 *
 * @author Abc
 */
public class ShippingOrderWorkRequest extends WorkRequest {

    private String ReferenceNo;
    private OrderItem orderItem;
    private CustomerAccount customerAccount;

    public ShippingOrderWorkRequest(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
    
    public String getReferenceNo() {
        return ReferenceNo;
    }

    public void setReferenceNo(String ReferenceNo) {
        this.ReferenceNo = ReferenceNo;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
  
    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return ReferenceNo;
    }

}
