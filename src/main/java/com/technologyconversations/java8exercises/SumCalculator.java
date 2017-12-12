package com.technologyconversations.java8exercises;

import java.util.List;

public class SumCalculator {

    public int calculate(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }

}
