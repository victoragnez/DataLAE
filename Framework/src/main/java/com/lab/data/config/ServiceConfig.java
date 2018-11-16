package com.lab.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.data.service.ProjetoService;

@Configuration
public class ServiceConfig {
	@Bean
	public ProjetoService projetoService() {
		return new ProjetoService();
	}
}
