package org.tom.usecase;

import org.junit.jupiter.api.Test;
import org.tom.helper.InMemoryComponents;

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
            public void instabilityIsUndefined() {
                fail();
            }

            @Override
            public void instabilityIsCalculated(String name, double instability) {
                fail();
            }
        });
    }

}