/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Organization.Organization;
import business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunjan
 */
public class ShippingEnterprise extends Enterprise {
        
    public ShippingEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.SHIPPINGENTERPRISE);
    }

    @Override
    public List<Organization.Type> getRelevantOrganizations() {
        ArrayList<Organization.Type> types = new ArrayList<>();
        types.add(Organization.Type.ShippingOrganization);  
        return types;   
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;    
    }
    
    
}
