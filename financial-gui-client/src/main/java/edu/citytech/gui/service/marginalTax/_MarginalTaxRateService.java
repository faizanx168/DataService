package edu.citytech.gui.service.marginalTax;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.gui.service._13FManagers.model.TaxApiResponse;
import edu.citytech.gui.service._13FManagers.model._TaxDetails;

import java.util.List;

public class _MarginalTaxRateService {
    private static final String URL = "http://localhost:9215/marginalTax/taxPaid?code=$code&salary=$salary&year=$year";

    public static TaxApiResponse findTaxDetails(String code, double salary, int year) {
        String dynamicURL = URL.replace("$code", code)
                .replace("$salary", String.valueOf(salary))
                .replace("$year", String.valueOf(year));
        System.out.println(dynamicURL);
        var results = JSONGet.submitGet(dynamicURL,TaxApiResponse.class );
        System.out.println(results);
        return  results;
    }
}