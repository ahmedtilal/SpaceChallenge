package com.company;

import java.util.Objects;

public record Item(String name, int weight) {

    public Item {
        Objects.requireNonNull(name);
    }
}
