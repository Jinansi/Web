/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

import business.Ecosystem;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class DepartmentCatalog {
   
    private ArrayList<Department> departmentList;

    public DepartmentCatalog() {
        this.departmentList = new ArrayList<>();
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }
    
    public boolean checkIfdepartmentNameIsUnique(String department){
        for(Department department1 : Ecosystem.getInstance().getDepartmentCatalog().getDepartmentList()){
            if(department1.getName().equalsIgnoreCase(department)){
                return false;
            }
        }
        return true;
    }
    
}
