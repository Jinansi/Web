/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.EmployeeRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class EmployeeOrganization extends Organization{

    public EmployeeOrganization(String name) {
        super(Type.Employee, name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EmployeeRole());
        return roles;
    }
    
}
