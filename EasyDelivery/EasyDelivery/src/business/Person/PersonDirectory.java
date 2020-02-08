/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import java.util.ArrayList;

/**
 *
 * @author gunjan
 */
public class PersonDirectory {

    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public Person createEmployee(String firstname, String lastname, int age) {
        Person person = new Person(firstname, lastname,age);
        personList.add(person);
        return person;
    }
}
