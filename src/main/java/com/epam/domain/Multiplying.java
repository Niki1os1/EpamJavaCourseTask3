package com.epam.domain;

public enum Multiplying {
    STALKS("stalks"), SEEDS("seeds"), LEAVES("leaves");

    private String name;

    public String getName() {
        return name;
    }

    Multiplying(String name) {
        this.name = name;
    }
}
