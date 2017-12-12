package com.technologyconversations.java8exercises;

import java.util.List;
import java.util.stream.Collectors;

public class FlatCollection {

    public List<String> transform(List<List<String>> toTransform) {
        return toTransform.stream().flatMap(strings -> strings.stream()).collect(Collectors.toList());
    }

}
