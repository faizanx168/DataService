package edu.citytech.gui.service._13FManagers.model;

public class TaxRule {
    private int rule;
    private double taxRate;
    private String code;
    private double range1;
    private double range2;
    private int year;

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRange1() {
        return range1;
    }

    public void setRange1(double range1) {
        this.range1 = range1;
    }

    public double getRange2() {
        return range2;
    }

    public void setRange2(double range2) {
        this.range2 = range2;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "TaxRule{" +
                "rule=" + rule +
                ", taxRate=" + taxRate +
                ", code='" + code + '\'' +
                ", range1=" + range1 +
                ", range2=" + range2 +
                ", year=" + year +
                '}';
    }
}
