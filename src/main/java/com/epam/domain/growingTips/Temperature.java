package com.epam.domain.growingTips;

public class Temperature extends GrowingTip {
    public Temperature() {
        super("Preferred growing temperature");
    }

    private Double temperature;

    @Override
    public void setValue(String value) {
        temperature = Double.parseDouble(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(temperature);
    }
}