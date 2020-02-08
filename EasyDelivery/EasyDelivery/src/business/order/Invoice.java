/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.order;

/**
 *
 * @author Gunjan
 */
public class Invoice {
    
    private int invoiceId;
    private Order order;
    private static int idcounter = 0;

    public Invoice(Order order) {
        invoiceId = idcounter++;
        this.order = order;

    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    
}
