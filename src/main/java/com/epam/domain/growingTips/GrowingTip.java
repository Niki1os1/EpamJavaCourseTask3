package com.epam.domain.growingTips;

public abstract class GrowingTip {
    private String name;
    private String element;

    public GrowingTip(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public abstract void setValue(String value);

    public abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}