package com.matheuscordeiro.conceptualmodels.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheuscordeiro.conceptualmodels.domain.BilletPayment;
import com.matheuscordeiro.conceptualmodels.domain.CardPayment;

@Configuration
public class JacksonConfig {
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(CardPayment.class);
				objectMapper.registerSubtypes(BilletPayment.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}