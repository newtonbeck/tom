package org.tom.domain;

import java.util.Objects;

public class Instability {

    private final double value;

    public Instability(FanOut fanOut, FanIn fanIn) {
        // TODO deal with division by zero later, maybe with a null object
        this.value = ((double) fanOut.value()) / (fanOut.value() + fanIn.value());
    }

    public double value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instability that = (Instability) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
