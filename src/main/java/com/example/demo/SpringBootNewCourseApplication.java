package com.example.demo;

import com.example.demo.context.BeanClass;
import com.example.demo.context.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootNewCourseApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootNewCourseApplication.class, args);
		var contextMethod=new AnnotationConfigApplicationContext(MyBean.class);
		ConfigurableApplicationContext contextClass = SpringApplication.run(SpringBootNewCourseApplication.class, args);

		System.out.println(contextMethod.getBean("name"));
		System.out.println(contextClass.getBean(BeanClass.class).returnBean());
	}

}
