package org.tom.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InstabilityTest {

    @Test
    public void fan_out_of_1_and_fan_in_of_2_should_generate_stability_of_0_333() {
        var instability = new Instability(new FanOut(1), new FanIn(2));

        assertEquals(0.333, instability.value(), 0.001);
    }

    @Test
    public void fan_out_of_1_and_fan_in_of_0_should_generate_stability_of_1() {
        var instability = new Instability(new FanOut(1), new FanIn(0));

        assertEquals(1, instability.value(), 0.1);
    }

    @Test
    public void fan_out_of_0_and_fan_in_of_1_should_generate_stability_of_0() {
        var instability = new Instability(new FanOut(0), new FanIn(1));

        assertEquals(0, instability.value(), 0.1);
    }

    @Test
    public void instability_value_should_always_be_greater_than_or_equals_to_0() {
        Random random = new Random();
        var instability = new Instability(
                new FanOut(Math.abs(random.nextInt(100_000)) + 1),
                new FanIn(Math.abs(random.nextInt(100_000)) + 1)
        );

        assertTrue(instability.value() >= 0);
    }

    @Test
    public void instability_value_should_always_be_lesser_than_or_equals_to_1() {
        Random random = new Random();
        var instability = new Instability(
                new FanOut(Math.abs(random.nextInt(100_000)) + 1),
                new FanIn(Math.abs(random.nextInt(100_000)) + 1)
        );

        assertTrue(instability.value() <= 1);
    }

}