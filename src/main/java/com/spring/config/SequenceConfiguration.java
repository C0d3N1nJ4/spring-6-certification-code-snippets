package com.spring.config;

import com.spring.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    includeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.REGEX,
                    pattern = {"com.spring.appcpntext.*Dao",
                               "com.spring.appcontext.*Service"})},
    excludeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    classes = {org.springframework.stereotype.Controller.class})})

public class SequenceConfiguration {

}
