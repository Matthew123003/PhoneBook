package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = new LinkedHashMap<>();
    }

    public PhoneBook() {

        this(null);//Set to 0
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
        //immutable list of one object, like casting
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, List.of(phoneNumbers));
        //put method adds to phonebook, if wrong type, use intellij
    }

    public void remove(String name) {

        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {

        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name);
    }
    public List<String> lookup(String name) {

        return phonebook.get(name);
        //This is to get the value by the key
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> contactNames = phonebook.keySet();
        //Gives you the full set of keys from the phonebook
        for(String key : contactNames){
            List<String> foundNumbers = phonebook.get(key);
            //Looping through the keySet to find values, and if it finds it, return that value
            if(foundNumbers.contains(phoneNumber)){
                return key;
            }
        }

        return null;
    }

    public List<String> getAllContactNames() {
        Set<String> contactNames = phonebook.keySet();
        //This is creating a set of strings, the is pulling all the keys from phonebook
        String[] nameArray = contactNames.toArray(new String[contactNames.size()]);
        //This is making a new string array to put all the contactNames list in, initialized to list size
        List<String> nameList = Arrays.asList(nameArray);
        //Turning array into a list to match return type
        return nameList;
    }

    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
