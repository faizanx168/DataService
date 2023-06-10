package edu.citytech.gui.service._13FManagers.model;

import java.util.List;

public class TaxApiResponse {
    private String date;
    private List<TaxRule> TaxRules;
    private double effectiveTaxRate;
    private String developer;
    private double taxPaid;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TaxRule> getTaxRules() {
        return TaxRules;
    }

    public void setTaxRules(List<TaxRule> taxRules) {
        TaxRules = taxRules;
    }

    public double getEffectiveTaxRate() {
        return effectiveTaxRate;
    }

    public void setEffectiveTaxRate(double effectiveTaxRate) {
        this.effectiveTaxRate = effectiveTaxRate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public double getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(double taxPaid) {
        this.taxPaid = taxPaid;
    }

    @Override
    public String toString() {
        return "TaxApiResponse{" +
                "date='" + date + '\'' +
                ", TaxRules=" + TaxRules +
                ", effectiveTaxRate=" + effectiveTaxRate +
                ", developer='" + developer + '\'' +
                ", taxPaid=" + taxPaid +
                '}';
    }
}
