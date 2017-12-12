package com.technologyconversations.java8exercises;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

class SumCalculatorSpec {

    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @Test
    void transformShouldConvertCollectionElementsToUpperCase() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Assertions.assertThat(sumCalculator.calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

}
