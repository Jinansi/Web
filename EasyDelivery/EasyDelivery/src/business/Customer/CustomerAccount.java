/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import business.Role.CustomerRole;
import business.UserAccount.UserAccount;
import business.order.OrderDirectory;

/**
 *
 * @author Gunjan
 */
public class CustomerAccount extends UserAccount {

    protected OrderDirectory orderDirectory;

    public CustomerAccount() {
        super.role = new CustomerRole();
        orderDirectory = new OrderDirectory();
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }


}
