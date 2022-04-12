package com.epam.domain.visualParameters;

public class LeafPresence extends VisualParameter {
    public LeafPresence() {
        super("Presence of leaves");
    }

    private Boolean leaf;

    @Override
    public void setValue(String value) {
        leaf = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(leaf);
    }
}