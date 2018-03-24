package com.dwe.dealwitheat.transaction.model;

public class Takings {

    public Takings() {
    }

    public Takings(String label, double value) {
        this.label = label;
        this.value = value;
    }

    private String label;
    private double value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
