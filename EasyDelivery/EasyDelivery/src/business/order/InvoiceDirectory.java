/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class InvoiceDirectory {
    
    private ArrayList<Invoice> invoicelist;

    public InvoiceDirectory() {
        invoicelist = new ArrayList<>();
    }
    
    public ArrayList<Invoice> getInvoicelist() {
        return invoicelist;
    }

    public void setInvoicelist(ArrayList<Invoice> invoicelist) {
        this.invoicelist = invoicelist;
    }

 
    
    
}
