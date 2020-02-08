/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.Customer.CustomerAccount;
import business.Network.Network;
import business.Person.Person;
import business.Role.CustomerRole;
import business.Role.Role;
import java.util.ArrayList;
import business.Ecosystem;
import business.Enterprise.Enterprise;
import business.Organization.Organization;

/**
 *
 * @author gunjan
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            System.out.print(ua.getUsername() + "\n");
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)) {

                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, Person employee, Role role) {
        UserAccount userAccount = new UserAccount();

        if (role instanceof CustomerRole) {
            userAccount = new CustomerAccount();
        } else {
            userAccount = new UserAccount();
            userAccount.setRole(role);
        }
        userAccount
                .setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(employee);

        userAccountList.add(userAccount);
        return userAccount;
    }

    public UserAccount getUserAccount(Role.RoleType roletype){
        for(UserAccount ua : userAccountList){
            if(ua.getRole().getType() == roletype)
                return ua;
            }
        return null;
    }
          
    
}
