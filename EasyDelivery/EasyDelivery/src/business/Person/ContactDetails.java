/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

/**
 *
 * @author Gunjan
 */
public class ContactDetails {
    private String emailId;
    private String primaryContactNo;
    private String secondaryContactNo;
    private String serviceprovider;

    public ContactDetails(String emailId, String primaryContactNo) {
        this.emailId = emailId;
        this.primaryContactNo = primaryContactNo;
    }
    
    public ContactDetails(){
        
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPrimaryContactNo() {
        return primaryContactNo;
    }

    public void setPrimaryContactNo(String primaryContactNo) {
        this.primaryContactNo = primaryContactNo;
    }

    public String getSecondaryContactNo() {
        return secondaryContactNo;
    }

    public void setSecondaryContactNo(String secondaryContactNo) {
        this.secondaryContactNo = secondaryContactNo;
    }

    public String getServiceprovider() {
        return serviceprovider;
    }

    public void setServiceprovider(String serviceprovider) {
        this.serviceprovider = serviceprovider;
    }
    
    
}
