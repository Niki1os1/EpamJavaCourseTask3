package com.epam.domain;

public enum Soil {
    PODZOLIC("podzolic"), UNPAVED("unpaved"), SOD_PODZOLIC("sod-podzolic");

    private String name;

    public String getName() {
        return name;
    }

    Soil(String name) {
        this.name = name;
    }
}