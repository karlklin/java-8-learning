package com.technologyconversations.java8exercises;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ToUpperCaseSpec {

    ToUpperCase toUpperCase;

    @BeforeEach
    void setUp() {
        toUpperCase = new ToUpperCase();
    }

    @Test
    void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");

        Assertions.assertThat(toUpperCase.transform(collection)).isEqualTo(expected);
    }

}
