package edu.citytech.gui.service.service;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Calculator {
    public int add(int n1, int n2) {
        return n1 + n2 ;
    }


    public double sum(double ...numbers) {
        double total = Arrays.stream(numbers).sum();
        return total;
    }

    public double max(double ...numbers) {
        OptionalDouble total = Arrays.stream(numbers).max();
        return total.getAsDouble();
    }

    public double min(double ...numbers) {
        OptionalDouble total = Arrays.stream(numbers).min();
        return total.getAsDouble();
    }
}
