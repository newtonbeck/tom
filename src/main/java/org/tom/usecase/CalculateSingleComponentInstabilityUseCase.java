package org.tom.usecase;

import org.tom.domain.Components;

public class CalculateSingleComponentInstabilityUseCase {

    private final Components components;

    public CalculateSingleComponentInstabilityUseCase(Components components) {
        this.components = components;
    }

    public interface Callback {

        void componentNotFound(String name);

        void instabilityIsUndefined(String name);

        void instabilityIsCalculated(String name, double instability);

    }

    public void calculate(String name, Callback callback) {
        this.components.findBy(name).ifPresentOrElse(
                component -> {
                    var instability = component.instability();
                    if (instability.value() == Double.NaN) {
                        callback.instabilityIsUndefined(name);
                    }
                },
                () -> callback.componentNotFound(name)
        );
    }

}
