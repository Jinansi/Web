/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gunjan
 */
public class Department {
   
    private String name;
    private ArrayList<Department> departmentList;
    private ArrayList<Product> productList;

    public Department(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
        departmentList = new ArrayList<>();
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public Set<Department> getAllTheChildrenDepartment(){
        
        Set<Department> departmentsToBeReturned = new HashSet<>();
        getChildren(this, departmentsToBeReturned);
        return departmentsToBeReturned;
        
    }
    
    private void getChildren(Department parentDep, Set<Department> allDept){
        
        allDept.add(parentDep);
        
        if(parentDep.getDepartmentList().size()==0){
            return;
        }
        
        for(Department childDep : parentDep.getDepartmentList()){
            getChildren(childDep, allDept);
        }
        
    }
    
     public boolean checkIfsubdepartmentNameIsUnique(String department){
        for(Department department1 : this.getDepartmentList()){
            if(department1.getName().equalsIgnoreCase(department)){
                return false;
            }
        }
        return true;
    }
     
    @Override
    public String toString(){
        return name;
    }
}
