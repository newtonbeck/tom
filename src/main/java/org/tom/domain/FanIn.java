package org.tom.domain;

import java.util.Objects;

public class FanIn {

    private int value;

    public FanIn() {
        this(0);
    }

    public FanIn(int value) {
        this.value = value;
    }

    public void increase() {
        this.value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FanIn fanIn = (FanIn) o;
        return value == fanIn.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
