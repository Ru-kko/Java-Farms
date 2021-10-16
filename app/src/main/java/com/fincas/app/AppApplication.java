package com.fincas.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppApplication extends SpringBootServletInitializer{
	@Value("${server.port}")
	private static int serverPort;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		System.out.println("\nListening in server port " + serverPort + "\n");
	}

}
