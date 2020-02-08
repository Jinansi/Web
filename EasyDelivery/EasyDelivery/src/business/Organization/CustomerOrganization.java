/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author gunjan
 */
public class CustomerOrganization extends Organization{
    
    public CustomerOrganization(String nameOfOrg) {
        super(Type.CustomerOrganization, nameOfOrg);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     return null;
    }
     
}