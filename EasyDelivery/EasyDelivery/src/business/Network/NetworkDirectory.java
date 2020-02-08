/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Network;

import business.Enterprise.Enterprise;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class NetworkDirectory {
    
    private ArrayList<Network> networkList;

    public NetworkDirectory() {
        this.networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network getNetwork(String name){
        for(Network network : networkList){
            if(network.getName().equalsIgnoreCase(name)){
                return network;
            }
        }
        return null;
    }
    
    public boolean checkNetwork(String network) {
        for (Network n : this.getNetworkList()) {
            if (n.getName().equalsIgnoreCase(network)) {
                return false;
            }
        }
        return true;
    }
    
    public Network createAndAddNetwork() {
        Network network = new Network();
        this.getNetworkList().add(network);
        return network;
    }

    public void delNetwork(Network network) {
        this.getNetworkList().remove(network);
    }
    
    public boolean checkIfUsernameIsUnique(String username) {
        for(Network network : this.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
                    for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()){
                        if (ua.getUsername().equals(username)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
