package org.tom.domain;

import java.util.Objects;

public class Component {

    private final String name;
    private final FanOut fanOut;

    public Component(String name) {
        this.name = Objects.requireNonNull(name, "Component name can not be null");
        this.fanOut = new FanOut();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public FanOut fanOut() {
        return this.fanOut;
    }
}
