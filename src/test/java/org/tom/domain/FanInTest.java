package org.tom.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FanInTest {

    @Test
    public void new_fan_in_should_be_created_with_value_0_by_default() {
        assertEquals(new FanIn(0), new FanIn());
    }

    @Test
    public void fan_in_should_be_increased_by_1_when_increase_is_invoked() {
        var fanIn = new FanIn();
        fanIn.increase();

        assertEquals(new FanIn(1), fanIn);
    }

    @Test
    public void value_should_be_retrieved_by_accessor() {
        var fanIn = new FanIn(3);

        assertEquals(3, fanIn.value());
    }

}