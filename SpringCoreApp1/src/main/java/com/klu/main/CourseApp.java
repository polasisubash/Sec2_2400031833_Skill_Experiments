package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.beans.Course;

public class CourseApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Course ct = context.getBean("course", Course.class);
		System.out.println("Course details");
		System.out.println("Course ID: " +ct.getcid());
		System.out.println("Course Name: " +ct.getcname());
		
}
}