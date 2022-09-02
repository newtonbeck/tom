package org.tom.helper;

import org.tom.domain.Component;
import org.tom.domain.Components;

import java.util.*;

public class InMemoryComponents implements Components {

    private final Map<String, Component> components;

    public InMemoryComponents() {
        this(Collections.emptyMap());
    }
    public InMemoryComponents(Map<String, Component> components) {
        this.components = components;
    }

    @Override
    public Set<Component> all() {
        return new HashSet<>(this.components.values());
    }

    @Override
    public Optional<Component> findBy(String name) {
        return Optional.ofNullable(this.components.get(name));
    }

}
