package edu.citytech.gui.service;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.gui.service._13FManagers._13FManagersService;
import edu.citytech.gui.service._13FManagers.model._13FDetails;
import edu.citytech.gui.service._13FManagers.model._13FManagers;
import edu.citytech.gui.service.marginalTax._MarginalTaxRateService;
import edu.citytech.gui.service.service.Calculator;
import javafx.scene.chart.PieChart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class T2_WebAPI {

    @Test
    @DisplayName("Web API")
    void t1_addition() {
        String stock = "AAPL";
        int limit  =14;
        var results =   _13FManagersService.find13FManagers(stock,limit);
        var actual = results.size();
        var expected = limit;
        System.out.println("Developer: Muhammad Faizan Abbasi"+ new Date());
        results.forEach(System.out::println);
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Web API")
    void t2_addition() {
        var tax = _MarginalTaxRateService.findTaxDetails("S", 150000,2022);
        System.out.println(tax);

    }

}

