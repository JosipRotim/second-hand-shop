package com.cardealership.springmvc;

import com.cardealership.springmvc.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

	@Import(JpaConfiguration.class)
	@SpringBootApplication(scanBasePackages={"com.cardealership.springmvc"})
	public class CarDealershipApp {

		public static void main(String[] args) {
			SpringApplication.run(CarDealershipApp.class, args);
		}
	}
