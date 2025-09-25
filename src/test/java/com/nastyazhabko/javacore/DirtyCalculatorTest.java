package com.nastyazhabko.javacore;

import com.nastyazhabko.javacore.tests.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirtyCalculatorTest {
    @Test
    public void shouldReturnCorrectSum() {
        // Проверка сложения
        Calculator calculator = TestHelper.createDefaultCalculator();
        int a = 2;
        int b = 3;

        int sum = calculator.sum(a, b);

        assertEquals(5,sum);
    }

    @Test
    public void shouldReturnCorrectSubtract() {
        // Проверка вычитания
        Calculator calculator = TestHelper.createDefaultCalculator();
        int a = 3;
        int b = 2;

        int substract = calculator.subtract(a, b);

        assertEquals(1, substract);
    }


    @Test
    public void shouldReturnCorrectMultiply() {
        // Проверка умножения
        Calculator calculator = TestHelper.createDefaultCalculator();
        int a= 2;
        int b= 3;

        int multiply = calculator.multiply(a, b);

        assertEquals(6, multiply);
    }
}
