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
public class EDEnterprise extends Enterprise {

    public EDEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.EDENTERPRISE);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public List<Type> getRelevantOrganizations() {
        ArrayList<Organization.Type> types = new ArrayList<>();
        types.add(Organization.Type.InventoryManagementOrganization);
        types.add(Organization.Type.CustomerOrganization);
        types.add(Organization.Type.Employee);
        return types;
    }
}
