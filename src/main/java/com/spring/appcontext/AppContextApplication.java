package com.spring.appcontext;


import com.spring.SequenceDao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppContextApplication {

	public static void main(String[] args) {


		var basePackage = "com.spring";
		try (var context = new AnnotationConfigApplicationContext(basePackage)) {
			var sequenceDao = context.getBean(SequenceDao.class);
			System.out.println(sequenceDao.getNextValue("IT"));
			System.out.println(sequenceDao.getNextValue("IT"));
		}
	}

}
