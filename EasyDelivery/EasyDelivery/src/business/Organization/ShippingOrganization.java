/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Network.Network;
import business.Role.Role;
import business.Role.ShippingRole;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class ShippingOrganization extends Organization {

    public ShippingOrganization(String name) {
        super(Organization.Type.ShippingOrganization, name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ShippingRole());
        return roles;
    }

}
