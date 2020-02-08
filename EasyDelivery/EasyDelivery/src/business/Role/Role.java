/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Ecosystem;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {

    // data members
    private RoleType type;

    // constructor
    public Role(RoleType type) {
        this.type = type;
    }

    public RoleType getType() {
        return type;
    }

    public enum RoleType {

        SystemAdmin("System Admin"),
        Admin("Admin"),
        Seller("Seller"),
        ShippingService("Shipping Service"),
        Customer("Customer"),
        InventoryManager("Inventory Manager"),
        Employee("Employee");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            Ecosystem business,
            Network network);

    @Override
    public String toString() {
        return this.getType().getValue();
    }

}
