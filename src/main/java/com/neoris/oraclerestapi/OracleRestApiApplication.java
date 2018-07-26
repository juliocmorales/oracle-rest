package com.neoris.oraclerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OracleRestApiApplication extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	
        return application.sources(OracleRestApiApplication.class);
    }


	public static void main(String[] args) {
		SpringApplication.run(OracleRestApiApplication.class, args);
	}
}
