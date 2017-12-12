package com.technologyconversations.java8exercises;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class FlatCollectionSpec {

    private FlatCollection flatCollection;

    @BeforeEach
    void setUp() {
        flatCollection = new FlatCollection();
    }

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        Assertions.assertThat(flatCollection.transform(collection)).isEqualTo(expected);
    }

}
