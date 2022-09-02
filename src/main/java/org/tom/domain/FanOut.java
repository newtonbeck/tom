package org.tom.domain;

import java.util.Objects;

public class FanOut {

    private int value;

    public FanOut() {
        this(0);
    }

    public FanOut(int value) {
        this.value = value;
    }

    public void increase() {
        this.value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FanOut fanOut = (FanOut) o;
        return value == fanOut.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
