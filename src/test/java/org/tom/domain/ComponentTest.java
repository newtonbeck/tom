package org.tom.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComponentTest {

    @Test
    public void two_components_with_same_name_should_be_equal() {
        var componentOne = new Component("org.tom.domain");
        var componentTwo = new Component("org.tom.domain");

        assertEquals(componentOne, componentTwo);
    }

    @Test
    public void component_with_null_name_should_not_be_created() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Component(null));
        assertEquals("Component name can not be null", exception.getMessage());
    }

}