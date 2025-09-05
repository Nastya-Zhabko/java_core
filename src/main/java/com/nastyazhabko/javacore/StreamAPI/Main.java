package com.nastyazhabko.javacore.StreamAPI;

public class Main {
    public void testCalculate(MyCalculator calc) {
        double result = calc.calculate(5, 10);
        System.out.println(result);
    }

    public static void main(String[] args) {

        Main mainCalculator = new Main();


        MyCalculator anonymCalc = new MyCalculator(){
            @Override
            public double calculate(double a, double b) {
                return a+b;
            }
        };

        mainCalculator.testCalculate(anonymCalc);



        MyCalculator lambdaCalc = (a,b) -> a+b;

        mainCalculator.testCalculate(lambdaCalc);

        System.out.println();
    }
}
