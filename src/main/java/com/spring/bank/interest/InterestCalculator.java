package com.spring.bank.interest;

public interface InterestCalculator {

    void setRate(double rate);

    double calculate(double amount, double year);
}
