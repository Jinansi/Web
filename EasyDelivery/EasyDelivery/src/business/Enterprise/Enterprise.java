/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Organization.Organization;
import business.Organization.OrganizationDirectory;
import business.Person.ContactDetails;
import business.order.InvoiceDirectory;
import business.order.PaymentDirectory;
import java.util.List;

/**
 *
 * @author Gunjan
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private ContactDetails contactDetails;
    private InvoiceDirectory invoiceDirectory;
    private PaymentDirectory paymentDirectory;
    private OrganizationDirectory organizationDirectory;

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Enterprise(String name, EnterpriseType type) {
        super(Organization.Type.Enterprise, name);
        this.enterpriseType = type;
        this.paymentDirectory = new PaymentDirectory();
        this.invoiceDirectory = new InvoiceDirectory();
        organizationDirectory = new OrganizationDirectory();
    }

    public enum EnterpriseType {

        SELLERENTERPRISE("Seller"),
        SHIPPINGENTERPRISE("Shipping"),
        EDENTERPRISE("Easy Delivery Enterprise");

        private String value;

        private EnterpriseType(String value) {
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

    public abstract List<Organization.Type> getRelevantOrganizations();

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public InvoiceDirectory getInvoiceDirectory() {
        return invoiceDirectory;
    }

    public void setInvoiceDirectory(InvoiceDirectory invoiceDirectory) {
        this.invoiceDirectory = invoiceDirectory;
    }

    public PaymentDirectory getPaymentDirectory() {
        return paymentDirectory;
    }

    public void setPaymentDirectory(PaymentDirectory paymentDirectory) {
        this.paymentDirectory = paymentDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public List<Organization> getOrganizations(Organization.Type type) {
        return organizationDirectory.getOrganizations(type);
    }

    public Organization getOrganization(Organization.Type type) {
        return organizationDirectory.getOrganization(type);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
