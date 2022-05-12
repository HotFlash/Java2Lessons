package ru.geekbrains.lesson3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
