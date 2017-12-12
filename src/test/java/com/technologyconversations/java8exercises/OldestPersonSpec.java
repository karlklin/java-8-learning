package com.technologyconversations.java8exercises;

import java8.in.action.optional.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OldestPersonSpec {

    private OldestPerson oldestPerson;

    @BeforeEach
    void setUp() {
        oldestPerson = new OldestPerson();
    }

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person victor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = Arrays.asList(sara, eva, victor);

        assertThat(oldestPerson.getOldestPerson(collection)).isLenientEqualsToByAcceptingFields(eva, "name", "age");
    }

}
