/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Organization.Organization;
import business.Organization.StockOrganization;
import business.Role.Role;
import business.UserAccount.UserAccount;
import business.Utils.GIS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gunjan
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (null != type){
            switch (type) {
            case SELLERENTERPRISE:
                enterprise = new SellerEnterprise(name);
                enterpriseList.add(enterprise);
                break;
            case SHIPPINGENTERPRISE:
                enterprise = new ShippingEnterprise(name);  
                enterpriseList.add(enterprise);
                break;
            case  EDENTERPRISE:
                enterprise = new EDEnterprise(name);  
                enterpriseList.add(enterprise);
                break;
            default:
                break;
            }
        }
        return enterprise;
    }
    
       public void delEnterprise(Enterprise enterprise){
        enterpriseList.remove(enterprise);
    }
    
    public boolean isEnterpriseNameAvailable(String name){
        for(Enterprise enterprisename  : enterpriseList){
             if(enterprisename.getName().equals(name)){
                return false;
            }   
        }
        return true;
    }
    
    public List<Enterprise> getEnterprises(Enterprise.EnterpriseType type){
        List<Enterprise> retList = new ArrayList<>();
        for(Enterprise enterprise: enterpriseList){
            if(enterprise.getEnterpriseType()==type){
                retList.add(enterprise);
            }
        }
        return retList;
    }

    public List<Organization> getOrganizations(Enterprise.EnterpriseType entType, Organization.Type orgType){
        List<Organization> retList = new ArrayList<>();
        for(Enterprise enterprise : getEnterprises(entType)){
            retList.addAll(enterprise.getOrganizations(orgType));
        }
        return retList;
    }
    
    public Organization getOrganization(Enterprise.EnterpriseType entType, Organization.Type orgType){
        for(Enterprise enterprise : getEnterprises(entType)){
            return enterprise.getOrganization(orgType);
        }
        return null;
    }
    
    public UserAccount  getUserAccount(Enterprise.EnterpriseType entType, Organization.Type orgType){
        for(Enterprise enterprise : getEnterprises(entType)){
            for(Organization org : enterprise.getOrganizations(orgType)){
                return org.getUserAccountDirectory().getUserAccount(Role.RoleType.Seller);
            }
             
        }
        return null;
    }
    
    public boolean hasEnterprise(Enterprise enterprise){
        for(Enterprise en:enterpriseList){
            if(enterprise == en){
                return true;
            }
        }
        return false;
    }
    
    // eg: getting nearest USPS from samsung warehouse
    public Organization getNearestServiceCentre(StockOrganization stockOrg , ShippingEnterprise ent){
        
        Organization nearestOrg = null;
        List<Organization> allServiceCentres = ent.getOrganizations(Organization.Type.ShippingOrganization);

        if(allServiceCentres.size()>0){
            
            nearestOrg = allServiceCentres.get(0);
            double minDistance = GIS.getDistance(stockOrg.getAddress(), nearestOrg.getAddress());
            
            boolean skipFirst = true;
            
            for(Organization currentOrg : allServiceCentres){
                
                if(skipFirst){
                    skipFirst = false;
                    continue;
                }
                
                double dist = GIS.getDistance(stockOrg.getAddress(), currentOrg.getAddress());
                
                if(dist < minDistance){
                    minDistance = dist;
                    nearestOrg = currentOrg;
                }
                
            }
            
        }
        return nearestOrg;
    }
    
}