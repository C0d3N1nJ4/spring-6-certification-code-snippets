package com.spring;

import com.spring.bank.InterestCalculator;
import com.spring.bank.SimpleInterestCalculator;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SimpleCalculatorTestsWithTestNG {

    private InterestCalculator interestCalculator;

    @BeforeMethod
    public void init() {
        interestCalculator = new SimpleInterestCalculator();
        interestCalculator.setRate(0.05);
    }

    @DataProvider(name = "calculateSource")
    public Object[][] calculateSource() {
        return new Object[][]{
                {10000.0, 2, 1000.0},
                {10000.0, 1, 500.0}
        };
    }

    @DataProvider(name = "illegalCalculateSource")
    public Object[][] illegalCalculateSource() {
        return new Object[][]{
                {-10000, 2},
                {10000, -2},
                {-10000, -2}
        };
    }

    @Test(dataProvider = "calculateSource")
    public void calculateWithMethodSource(double amount, double year, double expectedInterest) {
        var interest = interestCalculator.calculate(amount, year);
        assertEquals(expectedInterest, interest, 0);
    }

    @Test(dataProvider = "illegalCalculateSource", expectedExceptions = IllegalArgumentException.class)
    public void calculateWithMethodSourceNegativeAmount(double amount, double year) {
        interestCalculator.calculate(amount, year);
    }
}
