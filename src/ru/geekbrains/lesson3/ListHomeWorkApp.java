package ru.geekbrains.lesson3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListHomeWorkApp {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("two");
        stringList.add("five");
        stringList.add("nine");
        stringList.add("nine");
        stringList.add("two");
        stringList.add("five");
        stringList.add("seven");
        stringList.add("four");

        Set<String> UniqueStringList = new HashSet<>(stringList);
        System.out.println(UniqueStringList);
        Map<String, Long> countNoneUnique = stringList.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        countNoneUnique.forEach((value, count) -> System.out.println(value + ": " + count));

    }
}
