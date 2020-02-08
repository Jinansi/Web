/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Ecosystem;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Organization.Organization;
import business.Organization.ShippingOrganization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.shippingManagement.ShippingWorkAreaJPanel;

/**
 *
 * @author Abc
 */
public class ShippingRole extends Role {

    public ShippingRole() {
        super(RoleType.ShippingService);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new ShippingWorkAreaJPanel(userProcessContainer, account, business, (ShippingOrganization) organization);
    }

}
