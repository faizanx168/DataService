package edu.citytech.gui.service._13FManagers.model;

import java.util.List;

public class _TaxDetails {

    private List<TaxApiResponse> results;
    public List<TaxApiResponse> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "_TaxDetails{" +
                "results=" + results +
                '}';
    }
}
