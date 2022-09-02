package org.tom.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FanOutTest {

    @Test
    public void new_fan_out_should_be_created_with_value_0_by_default() {
        assertEquals(new FanOut(0), new FanOut());
    }

    @Test
    public void fan_out_should_be_increased_by_1_when_increase_is_invoked() {
        var fanOut = new FanOut();
        fanOut.increase();

        assertEquals(new FanOut(1), fanOut);
    }

    @Test
    public void value_should_be_retrieved_by_accessor() {
        var fanOut = new FanOut(3);

        assertEquals(3, fanOut.value());
    }

}