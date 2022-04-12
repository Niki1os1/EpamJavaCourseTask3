package com.epam.domain.growingTips;

public class Lighting extends GrowingTip {
    public Lighting() {
        super("Light-loving");
    }

    private Boolean lighting;

    @Override
    public void setValue(String value) {
        lighting = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(lighting);
    }
}