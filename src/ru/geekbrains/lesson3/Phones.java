package ru.geekbrains.lesson3;

import java.util.*;

public class Phones {

    Map<String, Set<String>> phonesByName = new TreeMap<>();

    public void add(String name, String phoneNumber) {
        Set<String> phones = phonesByName.getOrDefault(name, new HashSet<>());
        phones.add(phoneNumber);
        phonesByName.put(name, phones);
    }

    public Set<String> get(String name) {
        return phonesByName.get(name);
    }

    public Set<String> allNames() {
        return phonesByName.keySet();
    }
}
