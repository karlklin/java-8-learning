package com.technologyconversations.java8exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/*
Filter collection so that only elements with less then 4 characters are returned.
 */
class FilterCollectionSpec {

    private FilterCollection filterCollection;

    @BeforeEach
    void setUp() {
        filterCollection = new FilterCollection();
    }

    @Test
    void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertThat(filterCollection.transform(collection)).isEqualTo(expected);
    }

}