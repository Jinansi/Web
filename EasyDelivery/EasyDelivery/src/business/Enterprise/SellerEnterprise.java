/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Organization.InventoryManagementOrganization;
import business.Organization.Organization;
import business.Role.Role;
import business.WorkQueue.ProductOrderWorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunjan
 */
public class SellerEnterprise extends Enterprise {

    public SellerEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.SELLERENTERPRISE);
    }

    @Override
    public List<Type> getRelevantOrganizations() {
        ArrayList<Organization.Type> types = new ArrayList<>();
        types.add(Organization.Type.InventoryManagementOrganization);  
        return types; 
    }
    
    public void fulfillorders(ProductOrderWorkRequest request){
        
        List<Organization> orgList = this.getOrganizationDirectory().getOrganizations(Type.InventoryManagementOrganization);
        for(Organization org : orgList){
            InventoryManagementOrganization invOrg = (InventoryManagementOrganization)org;
            if(invOrg.isSKUPresent(request.getOrderItem().getSkuHolder().sku)){
                invOrg.getWorkQueue().getWorkRequestList().add(request);
            }
        }
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
      return null;
    }
    
    
}
