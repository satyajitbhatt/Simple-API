package com.example;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    
    private Map<String, Person> personMap = new HashMap<>();
    
    private static DataStore instance;
    
    public static DataStore getInstance() {
        instance = new DataStore();
	return instance;
    }
    
    private DataStore() {
        personMap.put("Sumbha", new Person("Sumbha", "Sumbha is Developer..!!!", 1994));
	personMap.put("Satu", new Person("Satu", "Satu is Developer..!!!", 1998));
	personMap.put("Divs", new Person("Divs", "Divs is Student..!!!", 2001));
        System.out.println(personMap);
    }
    
    public Person getPerson(String name) {
	return personMap.get(name);
    }

    public void putPerson(Person person) {
	personMap.put(person.getName(), person);
    }
}
