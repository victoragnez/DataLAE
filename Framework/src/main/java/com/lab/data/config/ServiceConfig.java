package com.lab.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.data.service.old.ArquivoService;
import com.lab.data.service.old.LocalService;
import com.lab.data.service.old.PesquisadorService;
import com.lab.data.service.old.ProjetoService;
import com.lab.data.service.old.ViagemService;

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
