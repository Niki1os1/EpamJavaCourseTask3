package com.epam.domain;

import com.epam.domain.growingTips.GrowingTip;
import com.epam.domain.visualParameters.VisualParameter;

import java.util.LinkedHashSet;
import java.util.Set;

public class Plant {
    private String identity;
    private String name;
    private Soil soil;
    private String origin;
    private Set<VisualParameter> visualParameters = new LinkedHashSet<>();
    private Set<GrowingTip> growingTips = new LinkedHashSet<>();
    private Multiplying multiplying;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Set<VisualParameter> getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(Set<VisualParameter> visualParameters) {
        this.visualParameters = visualParameters;
    }

    public Set<GrowingTip> getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(Set<GrowingTip> growingTips) {
        this.growingTips = growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(getIdentity()).append('\n');
        builder.append("Plant name: ").append(getName()).append('\n');
        builder.append("Soil for planting: ").append(getSoil().getName()).append('\n');
        builder.append("Place of origin: ").append(getOrigin()).append('\n');

        builder.append("External parameters:\n");
        for (VisualParameter visualParameter : getVisualParameters()) {
            builder.append('\t').append(visualParameter.getName()).append(": ").append(visualParameter.getValue()).append('\n');
        }

        builder.append("Preferred growing conditions:\n");
        for (GrowingTip growingTip : getGrowingTips()) {
            builder.append('\t').append(growingTip.getName()).append(": ").append(growingTip.getValue()).append('\n');
        }

        builder.append("Reproduction method: ").append(getMultiplying().getName()).append('\n');
        return builder.toString();
    }
}