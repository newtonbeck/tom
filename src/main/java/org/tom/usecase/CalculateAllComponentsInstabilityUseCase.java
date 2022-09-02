package org.tom.usecase;

import org.tom.domain.Components;

import java.util.Set;
import java.util.stream.Collectors;

public class CalculateAllComponentsInstabilityUseCase {

    private final Components components;

    public CalculateAllComponentsInstabilityUseCase(Components components) {
        this.components = components;
    }

    public interface Callback {

        void noComponentsWereFound();

        void allCalculated(Set<ComponentInstability> components);

        record ComponentInstability(String name, double instability) { }

    }

    public void calculate(Callback callback) {
        var componentsInstabilities = this.components.all().stream().map(component ->
                new Callback.ComponentInstability(
                        component.name(),
                        component.instability().value()
                )
        ).collect(Collectors.toSet());

        if (componentsInstabilities.isEmpty()) {
            callback.noComponentsWereFound();
        } else {
            callback.allCalculated(componentsInstabilities);
        }
    }

}
