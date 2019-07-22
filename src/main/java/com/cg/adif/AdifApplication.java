package com.cg.adif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.cg.*")
public class AdifApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdifApplication.class, args);
	}

}
