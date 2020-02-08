/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

import business.Enterprise.SellerEnterprise;

/**
 *
 * @author Gunjan
 */
// helper class to hold sku and its seller
public class SKUHolder {

        public SKU sku;
        public SellerEnterprise seller;

        public SKUHolder(SKU sku, SellerEnterprise seller) {
            this.sku = sku;
            this.seller = seller;
        }
        
        @Override
        public String toString(){
            return sku.toString();
        }
    }
