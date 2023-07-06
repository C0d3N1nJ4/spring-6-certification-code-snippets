package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {

    @Bean
    public Sequence sequence() {
        Sequence sequence = new Sequence();
        sequence.setPrefix("30");
        sequence.setSuffix("A");
        sequence.setInitial(100000);
        return sequence;
    }

}
