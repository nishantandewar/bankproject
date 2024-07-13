package com.nishant.bankproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Bank Project by nishant",
				description="Backend RestAPIs for Nishant's Bank project",
				version="5.0",
				contact=@Contact(
						name="Nishant Andewar",
						email="nishantandewar@gmail.com",
						url="https://github.com/nishantandewar/bankproject"),
				license=@License(
						name="Nishant Bank Appication Project ",
						url="https://github.com/nishantandewar/bankproject")
				),
		externalDocs=@ExternalDocumentation(
				description="Bank Application Documentation",
				url="https://github.com/nishantandewar/bankproject"))
public class BankprojectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BankprojectApplication.class, args);
	}

}
