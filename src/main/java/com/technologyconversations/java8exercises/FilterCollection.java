package com.technologyconversations.java8exercises;

import java.util.List;
import java.util.stream.Collectors;

public class FilterCollection {

    public List<String> transform(List<String> toTransform) {
        return toTransform.stream().filter(s -> s.length() < 4).collect(Collectors.toList());
    }

}
