package com.spring.classes;

import com.spring.interfaces.ArithmeticCalculator;
import org.springframework.stereotype.Component;

@Component
public class StandardArithmeticCalculator implements ArithmeticCalculator {

    @Override
    public double add(double a, double b) {
        double result = a + b;
        System.out.printf("%a + %b = %n", a, b, result);
        return result;
    }

    @Override
    public double sub(double a, double b) {
        double result = a - b;
        System.out.printf("%a - %b = %n", a, b, result);
        return result;
    }

    @Override
    public double mul(double a, double b) {
        double result = a * b;
        System.out.printf("%a * %b = %n", a, b, result);
        return result;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        double result = a / b;
        System.out.printf("%a / %b = %n", a, b, result);
        return result;
    }
}
