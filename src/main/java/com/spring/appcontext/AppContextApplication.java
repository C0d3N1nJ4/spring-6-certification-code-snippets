package com.spring.appcontext;

import com.spring.Sequence;
import com.spring.SequenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppContextApplication {

	public static void main(String[] args) {


		var config = SequenceConfiguration.class;
		try (var context = new AnnotationConfigApplicationContext(config)) {
			var generator = context.getBean(Sequence.class);
			System.out.println(generator.nextValue());
			System.out.println(generator.nextValue());
		}
	}

}
