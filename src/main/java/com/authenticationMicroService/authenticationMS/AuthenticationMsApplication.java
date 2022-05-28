package com.authenticationMicroService.authenticationMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackages = {"Repository"})
@EntityScan(basePackages = {"Documents"})
@ComponentScan(basePackages = {"controller"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthenticationMsApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthenticationMsApplication.class, args);
	}


}
