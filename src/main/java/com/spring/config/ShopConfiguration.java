package com.spring.config;

import com.spring.products.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.spring.products.Battery;
import com.spring.products.Disc;


@Configuration
public class ShopConfiguration {

    @Bean
    public Product aaa() {
        return new Battery("AAA", 2.5, true );

    }

    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 1.5, 700 );

    }


}
