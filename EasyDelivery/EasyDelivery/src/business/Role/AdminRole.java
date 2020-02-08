/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Ecosystem;
import business.Enterprise.EDEnterprise;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.AdminRole.AdminWorkArea;

/**
 *
 * @author Gunjan
 */
public class AdminRole extends Role {

    public AdminRole() {
        super(RoleType.Admin);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new AdminWorkArea(userProcessContainer, enterprise,business,network);
    }

}
