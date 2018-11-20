package com.lab.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.data.dao.ProjetoGeologiaDAO;
import com.lab.data.model.ProjetoGeologia;
import com.lab.data.service.ProjetoGeologiaService;
import com.lab.data.service.old.ArquivoService;
import com.lab.data.service.old.LocalService;
import com.lab.data.service.old.PesquisadorService;
import com.lab.data.service.old.ProjetoService;
import com.lab.data.service.old.ViagemService;

import framework.service.ServiceProjeto;

@Configuration
public class ServiceConfig {
	@Bean
	public ServiceProjeto<ProjetoGeologia> projetoService() {
		return new ProjetoGeologiaService(
				new ProjetoGeologiaDAO());
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
