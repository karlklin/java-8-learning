package com.technologyconversations.java8exercises;

import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCase {

    public List<String> transform(List<String> toTransform) {
        return toTransform.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    }
}
