package com.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
@Aspect
@Component
@Order(0)
public class CalculatorValidationAspect {


}
