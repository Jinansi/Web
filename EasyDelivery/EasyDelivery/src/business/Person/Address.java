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
public class Address {
    private String Addressline1;
    private String AddressLine2;
    private String city;
    private String zipcode;
    private String state;
    private String country;

    public Address(String Addressline1, String city, String zipcode, String state, String country) {
        this.Addressline1 = Addressline1;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.country = country;
    }
    
    public Address(){
        
    }

    
    public String getAddressline1() {
        return Addressline1;
    }

    public void setAddressline1(String Addressline1) {
        this.Addressline1 = Addressline1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getAddressline1()+" " +getCity()+" " +getState()+" " +getCountry()+" " +getZipcode();
    }
    
    
}
