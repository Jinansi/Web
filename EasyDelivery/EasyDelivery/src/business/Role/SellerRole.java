/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Ecosystem;
import business.Enterprise.Enterprise;
import business.Enterprise.SellerEnterprise;
import business.Network.Network;
import business.Organization.InventoryManagementOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.SellerManagement.SellerWorkAreaJPanel;

/**
 *
 * @author Gunjan
 */
public class SellerRole extends Role {

    public SellerRole() {
        super(Role.RoleType.Seller);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new SellerWorkAreaJPanel(userProcessContainer,account, business ,(InventoryManagementOrganization)organization, (SellerEnterprise)enterprise,network);
    }
}
