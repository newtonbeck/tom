package org.tom.domain;

import java.util.Optional;
import java.util.Set;

public interface Components {

    Set<Component> all();

    Optional<Component> findBy(String name);

}
