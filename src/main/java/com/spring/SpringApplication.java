package com.spring;

import com.spring.config.CalculatorConfiguration;
import com.spring.interfaces.ArithmeticCalculator;
import com.spring.interfaces.UnitCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringApplication {

    public static void main(String[] args) {

        var cfg = CalculatorConfiguration.class;
        try (var context = new AnnotationConfigApplicationContext(cfg)) {
            var arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
                arithmeticCalculator.add(1, 2);
                arithmeticCalculator.sub(4, 3);
                arithmeticCalculator.mul(2, 3);
                arithmeticCalculator.div(12, 2);

            var unitCalculator = context.getBean(UnitCalculator.class);
                unitCalculator.kilogramToPound(10);
                unitCalculator.kilometerToMile(5);
        }
    }
}
