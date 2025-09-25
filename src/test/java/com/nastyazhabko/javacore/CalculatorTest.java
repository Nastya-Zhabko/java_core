package com.nastyazhabko.javacore;

import com.nastyazhabko.javacore.tests.Calculator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @Test
    public void sumPositiveTest() {
        Calculator calc = new Calculator();
        int a=5;
        int b=10;

        int result = calc.sum(a,b);

        assertEquals(15, result);
    }

    @Test
    public void sumNegativeTest() {
        Calculator calc = new Calculator();
        int a=-5;
        int b=-10;

        int result = calc.sum(a,b);

        assertEquals(-15, result);
    }

    @Test
    public void multiplyRegularTest() {
        Calculator calc = new Calculator();
        int a=5;
        int b=10;
        int result = calc.multiply(a,b);
        assertEquals(50, result);
    }

    @Test
    public void multiplyZeroTest() {
        Calculator calc = new Calculator();
        int a=0;
        int b=10;
        int result = calc.multiply(a,b);
        assertEquals(0, result);
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }
}
