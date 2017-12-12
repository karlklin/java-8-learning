package com.technologyconversations.java8exercises;

import java8.in.action.optional.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdultPartition {
    public Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
        return collection.stream().collect(Collectors.partitioningBy(o -> o.getAge() > 24));
    }
}
