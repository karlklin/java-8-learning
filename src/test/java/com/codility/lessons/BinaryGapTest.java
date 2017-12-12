package com.codility.lessons;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class BinaryGapTest {

    private BinaryGap binaryGap;

    @BeforeEach
    void setUp() {
        binaryGap = new BinaryGap();
    }

    @Test
    void return0For1() {
        Assertions.assertThat(binaryGap.solution(1)).isEqualTo(0);
    }

    @Test
    void return0For15() {
        Assertions.assertThat(binaryGap.solution(15)).isEqualTo(0);
    }

    @Test
    void return1For20() {
        Assertions.assertThat(binaryGap.solution(20)).isEqualTo(1);
    }

    @Test
    void return2For9() {
        Assertions.assertThat(binaryGap.solution(9)).isEqualTo(1);
    }

    @Test
    void return5For1041() {
        Assertions.assertThat(binaryGap.solution(1041)).isEqualTo(5);
    }
}
