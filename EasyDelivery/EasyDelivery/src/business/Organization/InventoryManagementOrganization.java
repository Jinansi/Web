/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.Role;
import business.Role.SellerRole;
import java.util.ArrayList;

/**
 *
 * @author gunjan
 */
public class InventoryManagementOrganization extends StockOrganization{

    public InventoryManagementOrganization(String inventoryOrgName) {
        super(Organization.Type.InventoryManagementOrganization, inventoryOrgName);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SellerRole());
        return roles;
    }
     
    @Override
    public String toString(){
        return this.getName();
    }
}
