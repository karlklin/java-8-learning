package com.technologyconversations.java8exercises;

import java8.in.action.optional.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AdultPartitionSpec {

    private AdultPartition adultsPartitioner;

    @BeforeEach
    void setUp() {
        adultsPartitioner = new AdultPartition();
    }

    @Test
    void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person victor = new Person("Victor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, victor);

        Map<Boolean, List<Person>> result = adultsPartitioner.partitionAdults(collection);
        assertThat(result.get(true)).contains(victor, eva);
        assertThat(result.get(false)).contains(sara);
    }

}
