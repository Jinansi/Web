/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

/**
 *
 * @author gunjan
 */
public class Person {

    private String firstName;
    private String lastName;
    private int personId;
    private int age;
    private ContactDetails contactDetails;
    private static int count = 1;

    public enum Gender {

        MALE("Male"),
        FEMALE("Female");

        private String value;

        private Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return value;
        }
    }

    public Person(String firstname, String lastname, int age) {
        personId = count++;
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
        contactDetails = new ContactDetails();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
    
    @Override
    public String toString() {
        return this.getFirstName()+" "+getLastName();
    }

}
