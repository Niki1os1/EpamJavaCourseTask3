package com.epam.domain.growingTips;

public class Watering extends GrowingTip {
    public Watering() {
        super("Watering (ml per week)");
    }

    private Integer milliliters;

    @Override
    public void setValue(String value) {
        milliliters = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(milliliters);
    }
}