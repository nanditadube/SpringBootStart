package com.mygit.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mygit.boot"})
public class SampleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleBootApplication.class, args);
	}
}
