package com.spring;

import com.spring.bank.interest.InterestCalculator;
import com.spring.bank.interest.SimpleInterestCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleInterestCalculatorTestsJunit {

	private InterestCalculator interestCalculator;

	@BeforeEach
	void init() {
		interestCalculator = new SimpleInterestCalculator();
		interestCalculator.setRate(0.05);
	}

	@Test
	void calculate() {
		var interest = interestCalculator.calculate(10000, 2);
		assertEquals(1000.0, interest, 0);
	}

	@Test
	void calculateNegativeAmount() {
		assertThrows(IllegalArgumentException.class, () -> interestCalculator.calculate(-10000, 2));
	}


	private static Stream<Arguments> calculateSource() {
		return Stream.of(
				Arguments.of(10000.0, 2, 1000.0),
				Arguments.of(10000.0, 1, 500.0));
	}


	private static Stream<Arguments> illegalCalculateSource() {
		return Stream.of(
				Arguments.of(-10000, 2),
				Arguments.of(10000, -2),
				Arguments.of(-10000, -2)
		);
	}

	@ParameterizedTest
	@MethodSource("calculateSource")
	void calculateWithMethodSource(double amount, double year, double expectedInterest) {
		var interest = interestCalculator.calculate(amount, year);
		assertEquals(expectedInterest, interest, 0);
	}

	@ParameterizedTest
	@MethodSource("illegalCalculateSource")
	void calculateWithMethodSourceNegativeAmount(double amount, double year) {
		assertThrows(IllegalArgumentException.class, () -> interestCalculator.calculate(amount, year));
	}

}
