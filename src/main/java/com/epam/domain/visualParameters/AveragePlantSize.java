package com.epam.domain.visualParameters;

public class AveragePlantSize extends VisualParameter {
    public AveragePlantSize() {
        super("Average plant size");
    }

    private Integer size;

    @Override
    public void setValue(String value) {
        size = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(size);
    }
}