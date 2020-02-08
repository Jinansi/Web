/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import java.util.ArrayList;
import business.Organization.Organization.Type;
import java.util.List;

/**
 *
 * @author gunjan
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type, String name){
        Organization organization = null;
        if (type.getValue().equals(Type.CustomerOrganization.getValue())){
            organization = new CustomerOrganization(name);
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.InventoryManagementOrganization.getValue())){
            organization = new InventoryManagementOrganization(name);
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization(name);
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.ShippingOrganization.getValue())){
            organization = new ShippingOrganization(name);
            organizationList.add(organization);
        }
        return organization;
    }
    
  public List<Organization> getOrganizations(Organization.Type type){
        List<Organization> retList = new ArrayList<>();
        for(Organization org : organizationList){
            if(org.getType()==type){
                retList.add(org);
            }
        }
        return retList;
    }
  
  
  public Organization getOrganization(Organization.Type type){
        for(Organization organization : organizationList){
            if(organization.getType() == type) {
            return organization;  
            }
        }
    return null; 
  }
}