/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Inventory.DepartmentCatalog;
import business.Network.Network;
import business.Network.NetworkDirectory;
import business.Organization.Organization;
import business.Role.Role;
import business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class Ecosystem extends Organization {

    private static Ecosystem system;
    private NetworkDirectory networkDirectory;
    private DepartmentCatalog departmentCatalog;

    public static Ecosystem getInstance() {
        if (system == null) {
            system = new Ecosystem();
        }
        return system;
    }
    
    public static void setInstance(Ecosystem sys){
        system = sys;
    }

    private Ecosystem() {
        super(Organization.Type.Ecosystem, "Ecosystem");
        networkDirectory = new NetworkDirectory();
        departmentCatalog = new DepartmentCatalog();
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    public DepartmentCatalog getDepartmentCatalog() {
        return departmentCatalog;
    }

    public void setDepartmentCatalog(DepartmentCatalog departmentCatalog) {
        this.departmentCatalog = departmentCatalog;
    }

    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }



}
