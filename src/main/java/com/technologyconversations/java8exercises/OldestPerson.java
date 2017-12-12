package com.technologyconversations.java8exercises;

import java8.in.action.optional.Person;

import java.util.Comparator;
import java.util.List;

public class OldestPerson {
    public Person getOldestPerson(List<Person> collection) {
        return collection.stream().max(Comparator.comparing(Person::getAge)).get();
    }
}
