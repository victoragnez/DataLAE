package com.lab.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.data.service.ArquivoService;
import com.lab.data.service.LocalService;
import com.lab.data.service.PesquisadorService;
import com.lab.data.service.ProjetoService;
import com.lab.data.service.ViagemService;

@Configuration
public class ServiceConfig {
	@Bean
	public ProjetoService projetoService() {
		return new ProjetoService();
	}
	
	@Bean
	public LocalService localService() {
		return new LocalService();
	}
	
	@Bean
	public ViagemService viagemService() {
		return new ViagemService();
	}
	
	@Bean
	public PesquisadorService pesquisadorService() {
		return new PesquisadorService();
	}
	
	@Bean
	public ArquivoService arquivoService() {
		return new ArquivoService();
	}
}
