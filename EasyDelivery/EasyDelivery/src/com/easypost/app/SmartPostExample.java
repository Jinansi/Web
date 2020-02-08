package com.easypost.app;

import business.Organization.InventoryManagementOrganization;
import business.Organization.ShippingOrganization;
import business.WorkQueue.ShippingOrderWorkRequest;
import com.easypost.exception.EasyPostException;
import com.easypost.model.Address;
import com.easypost.model.Parcel;
import com.easypost.model.Shipment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartPostExample {

//    public static void main(String[] args) {
//        EasyPost.apiKey = "xIPc8HjQvHBzivveZd5dpA";
//
//        makeParcel();
//
//    }
    public void makeParcel(ShippingOrderWorkRequest request, ShippingOrganization org) {
        Map<String, Object> toAddressMap = new HashMap<String, Object>();
        toAddressMap.put("name", request.getCustomerAccount().getPerson());
        toAddressMap.put("street1", request.getCustomerAccount().getAddress().getAddressline1());
        toAddressMap.put("street2", request.getCustomerAccount().getAddress().getAddressLine2());
        toAddressMap.put("city", request.getSender().getAddress().getCity());
        toAddressMap.put("state", request.getSender().getAddress().getState());
        toAddressMap.put("zip", request.getSender().getAddress().getZipcode());
        toAddressMap.put("phone", request.getSender().getPerson().getContactDetails().getPrimaryContactNo());

        Map<String, Object> fromAddressMap = new HashMap<String, Object>();
        fromAddressMap.put("name", org.getName());
        fromAddressMap.put("street1", org.getAddress().getAddressline1());
        fromAddressMap.put("street2", org.getAddress().getAddressLine2());
        fromAddressMap.put("city", org.getAddress().getCity());
        fromAddressMap.put("state", org.getAddress().getState());
        fromAddressMap.put("zip", org.getAddress().getZipcode());
        fromAddressMap.put("phone",org.getContactDetails().getPrimaryContactNo());
        fromAddressMap.put("country",org.getAddress().getCountry());

        Map<String, Object> parcelMap = new HashMap<String, Object>();
        parcelMap.put("weight", 20);
        parcelMap.put("length", 6);
        parcelMap.put("width", 8);
        parcelMap.put("height", 1);

        try {
            Address fromAddress = Address.create(fromAddressMap);
            Address toAddress = Address.create(toAddressMap);
            Parcel parcel = Parcel.create(parcelMap);

            toAddress.verify("xIPc8HjQvHBzivveZd5dpA");

            // Address verified = to_address.verify();
            // create shipment
            Map<String, Object> shipmentMap = new HashMap<String, Object>();
            shipmentMap.put("to_address", toAddress);
            shipmentMap.put("from_address", fromAddress);
            shipmentMap.put("parcel", parcel);

            Map<String, Object> shipmentOptions = new HashMap<String, Object>();
            shipmentOptions.put("smartpost_hub", 5552);
            shipmentOptions.put("smartpost_manifest", "123456789");
            shipmentMap.put("options", shipmentOptions);

            Shipment shipment = Shipment.create(shipmentMap);

            // buy postage
            List<String> buyServiceCodes = new ArrayList<String>();
            buyServiceCodes.add("fedex.smart_post");

            Map<String, Object> buyMap = new HashMap<String, Object>();
            buyMap.put("rate", shipment.lowestRate(buyServiceCodes));
            buyMap.put("insurance", 249.99);

            // shipment = shipment.buy(shipment.lowestRate(buyCarriers, buyServices));
            shipment = shipment.buy(buyMap);

            Map<String, Object> labelMap = new HashMap<String, Object>();
            labelMap.put("file_format", "pdf");
            shipment = shipment.label(labelMap);

            System.out.println(shipment.prettyPrint());

        } catch (EasyPostException e) {
            e.printStackTrace();
        }
    }

}
