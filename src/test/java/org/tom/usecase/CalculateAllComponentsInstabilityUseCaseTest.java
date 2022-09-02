package org.tom.usecase;

import org.junit.jupiter.api.Test;
import org.tom.domain.Component;
import org.tom.helper.InMemoryComponents;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CalculateAllComponentsInstabilityUseCaseTest {

    @Test
    public void no_components_were_found_should_be_invoked() {
        var useCase = new CalculateAllComponentsInstabilityUseCase(new InMemoryComponents());

        useCase.calculate(new CalculateAllComponentsInstabilityUseCase.Callback() {
            @Override
            public void noComponentsWereFound() {
                assertTrue(true);
            }

            @Override
            public void allCalculated(Set<ComponentInstability> components) {
                fail();
            }
        });
    }

    @Test
    public void all_calculated_should_be_invoked() {
        var components = Map.of("org.tom.domain", new Component("org.tom.domain"));
        var useCase = new CalculateAllComponentsInstabilityUseCase(new InMemoryComponents(components));

        useCase.calculate(new CalculateAllComponentsInstabilityUseCase.Callback() {
            @Override
            public void noComponentsWereFound() {
                fail();
            }

            @Override
            public void allCalculated(Set<ComponentInstability> components) {
                assertEquals(Set.of(new ComponentInstability("org.tom.domain", Double.NaN)), components);
            }
        });
    }
}