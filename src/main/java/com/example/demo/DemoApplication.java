package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//		TestController controller = new TestController();
//
//		JButton button = new JButton("Push me!");
//
//		button.addActionListener(e -> {
//			controller.hello();
//		});
	}
}
