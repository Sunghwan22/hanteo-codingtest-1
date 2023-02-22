package com.hanteo.codingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CodingtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingtestApplication.class, args);
    }

    @Bean
				public WebSecurityCustomizer ignoringCustomizer() {
						return (web -> web.ignoring().requestMatchers("/**"));
				}
}
