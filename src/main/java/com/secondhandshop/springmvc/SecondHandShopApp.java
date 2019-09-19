package com.secondhandshop.springmvc;

import com.secondhandshop.springmvc.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

	@Import(JpaConfiguration.class)
	@SpringBootApplication(scanBasePackages={"com.secondhandshop.springmvc"})
	public class SecondHandShopApp {

		public static void main(String[] args) {
			SpringApplication.run(SecondHandShopApp.class, args);
		}
	}
