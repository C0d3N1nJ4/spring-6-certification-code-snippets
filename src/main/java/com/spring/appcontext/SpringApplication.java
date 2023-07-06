package com.spring.appcontext;


import com.spring.config.ShopConfiguration;
import com.spring.products.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        var cfg = ShopConfiguration.class;

        try (var context = new AnnotationConfigApplicationContext(cfg)) {
            var aaa = context.getBean("aaa", Product.class);
            var cdrw = context.getBean("cdrw", Product.class);
            System.out.println(aaa);
            System.out.println(cdrw);
        }
    }




}
