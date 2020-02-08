/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.Person.Address;
import business.Person.Person;
import business.Role.Role;
import business.WorkQueue.WorkQueue;

/**
 *
 * @author gunjan
 */
public class UserAccount {

    private String username;
    private String password;
    private Person person;
    protected Role role;
    private WorkQueue workQueue;
    private Address address;
    
    public UserAccount() {
        workQueue = new WorkQueue();
        address = new Address();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   

    @Override
    public String toString() {
        return username;
    }

}
