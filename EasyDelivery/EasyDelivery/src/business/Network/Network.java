/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Network;

import business.Enterprise.EnterpriseDirectory;
import business.Inventory.MasterProductCatalog;
import business.order.OrderDirectory;

/**
 *
 * @author Gunjan
 */
public class Network {

    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private NetworkDirectory networkDirectory;
    private OrderDirectory orderDirectory;
    private MasterProductCatalog masterProductCatalog;

    public Network() {
        this.enterpriseDirectory = new EnterpriseDirectory();
        this.networkDirectory = new NetworkDirectory();
        this.orderDirectory = new OrderDirectory();
        this.masterProductCatalog = new MasterProductCatalog();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    public MasterProductCatalog getMasterProductCatalog() {
        return masterProductCatalog;
    }

    public void setMasterProductCatalog(MasterProductCatalog masterProductCatalog) {
        this.masterProductCatalog = masterProductCatalog;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
