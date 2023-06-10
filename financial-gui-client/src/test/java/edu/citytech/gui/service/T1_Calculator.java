package edu.citytech.gui.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.citytech.gui.service.service.Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class T1_Calculator {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("addition")
    void t1_addition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("addition/sum")
    void t2_sum() {
        assertEquals(5, calculator.sum(1,1,1,1,1));
    }

    @Test
    @DisplayName("max")
    void t3_max() {
        assertEquals(55, calculator.max(32,13,55,14,1,15));
    }

    @Test
    @DisplayName("min")
    void t4_max() {
        assertEquals(1, calculator.min(32,13,55,14,1,15));
    }

}

