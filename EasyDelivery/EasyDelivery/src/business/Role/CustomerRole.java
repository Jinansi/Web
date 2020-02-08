/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Customer.CustomerAccount;
import business.Ecosystem;
import business.Enterprise.EDEnterprise;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Organization.CustomerOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.Customer.ShoppingCartJPanel;

/**
 *
 * @author Gunjan
 */
public class CustomerRole extends Role{

    public CustomerRole() {
        super(Role.RoleType.Customer);
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new ShoppingCartJPanel(userProcessContainer,(EDEnterprise)enterprise,(CustomerOrganization)organization, (CustomerAccount)account ,business, network);
    }
   
}
