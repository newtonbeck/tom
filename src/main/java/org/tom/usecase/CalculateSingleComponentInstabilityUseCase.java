package org.tom.usecase;

import org.tom.domain.Components;

public class CalculateSingleComponentInstabilityUseCase {

    private final Components components;

    public CalculateSingleComponentInstabilityUseCase(Components components) {
        this.components = components;
    }

    public interface Callback {

        void componentNotFound(String name);

        void instabilityIsUndefined();

        void instabilityIsCalculated(String name, double instability);

    }

    public void calculate(String name, Callback callback) {
        this.components.findBy(name).ifPresentOrElse(
                component -> System.out.println(component),
                () -> callback.componentNotFound(name)
        );
    }

}
