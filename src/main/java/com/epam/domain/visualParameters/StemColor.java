package com.epam.domain.visualParameters;

public class StemColor extends VisualParameter {
    public StemColor() {
        super("Stem color");
    }

    private String color;

    @Override
    public void setValue(String value) {
        color = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(color);
    }
}