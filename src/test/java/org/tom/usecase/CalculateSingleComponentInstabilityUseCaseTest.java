package org.tom.usecase;

import org.junit.jupiter.api.Test;
import org.tom.domain.Component;
import org.tom.helper.InMemoryComponents;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculateSingleComponentInstabilityUseCaseTest {

    @Test
    public void component_not_found_should_be_invoked_when_component_does_not_exist() {
        var useCase = new CalculateSingleComponentInstabilityUseCase(new InMemoryComponents());

        useCase.calculate("org.tom.domain", new CalculateSingleComponentInstabilityUseCase.Callback() {
            @Override
            public void componentNotFound(String name) {
                assertEquals("org.tom.domain", name);
            }

            @Override
            public void instabilityIsUndefined(String name) {
                fail();
            }

            @Override
            public void instabilityIsCalculated(String name, double instability) {
                fail();
            }
        });
    }

    @Test
    public void instability_is_undefined_should_be_invoked_when_components_instability_is_0_divided_by_0() {
        var components = Map.of("org.tom.domain", new Component("org.tom.domain"));
        var useCase = new CalculateSingleComponentInstabilityUseCase(new InMemoryComponents(components));

        useCase.calculate("org.tom.domain", new CalculateSingleComponentInstabilityUseCase.Callback() {
            @Override
            public void componentNotFound(String name) {
                fail();
            }

            @Override
            public void instabilityIsUndefined(String name) {
                assertEquals("org.tom.domain", name);
            }

            @Override
            public void instabilityIsCalculated(String name, double instability) {
                fail();
            }
        });
    }

    @Test
    public void instability_is_calculated_should_be_invoked_when_components_instability_exists() {
        var component = new Component("org.tom.domain");
        component.fanOut().increase();
        component.fanIn().increase();
        component.fanIn().increase();

        var components = Map.of("org.tom.domain", component);
        var useCase = new CalculateSingleComponentInstabilityUseCase(new InMemoryComponents(components));

        useCase.calculate("org.tom.domain", new CalculateSingleComponentInstabilityUseCase.Callback() {
            @Override
            public void componentNotFound(String name) {
                fail();
            }

            @Override
            public void instabilityIsUndefined(String name) {
                fail();
            }

            @Override
            public void instabilityIsCalculated(String name, double instability) {
                assertEquals("org.tom.domain", name);
                assertEquals(0.333, instability, 0.001);
            }
        });
    }

}