/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class EmployeeRole extends Role{

    public EmployeeRole() {
        super(Role.RoleType.Employee);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, Network network) {
        return new AdminWorkArea(userProcessContainer, (EDEnterprise)enterprise,business, network);
    }
    
}
