/*
 * To change this template, choose Tools | Templates
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
import userInterface.SellerManagement.ManageInventory;
/**
 *
 * @author raunak
 */
public class InventoryManagerRole extends Role {

    public InventoryManagerRole() {
        super(RoleType.InventoryManager);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new ManageInventory(userProcessContainer, account, business,(InventoryManagementOrganization)organization, (SellerEnterprise)enterprise);
    }
}
