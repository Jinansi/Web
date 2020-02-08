/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Utils;

import business.Person.Address;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Lookup;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Gunjan
 */
public class AddressValidation {
    
    public static boolean validate(Address address) {

        StaticCredentials credentials = new StaticCredentials("79fc7a8d-43ac-8071-2b10-059e1b4f4ddc", "KOACSLJoeYLwfs7WbkeG");
        Client client = new ClientBuilder(credentials)
//                .withProxy(Proxy.Type.HTTP, "localhost", 8080) // Uncomment this line to try it with a proxy
                .buildUsStreetApiClient();

        Lookup lookup = new Lookup();
        lookup.setStreet(address.getAddressline1());
        lookup.setCity(address.getCity());
        lookup.setState(address.getState());
        lookup.setZipCode(address.getZipcode());

        try {
            client.send(lookup);
        }
        catch (SmartyException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Candidate> results = lookup.getResult();

        if (results.isEmpty()) {
            System.out.println("No candidates. This means the address is not valid.");
            return false;
        }

        Candidate firstCandidate = results.get(0);

        System.out.println("Address is valid. (There is at least one candidate)\n");
        System.out.println("ZIP Code: " + firstCandidate.getComponents().getZipCode());
        System.out.println("County: " + firstCandidate.getMetadata().getCountyName());
        System.out.println("Latitude: " + firstCandidate.getMetadata().getLatitude());
        System.out.println("Longitude: " + firstCandidate.getMetadata().getLongitude());
        return true;
    }
    

    
}
