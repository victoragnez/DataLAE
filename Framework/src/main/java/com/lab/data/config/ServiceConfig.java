package com.lab.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.data.dao.AreaGeologiaDAO;
import com.lab.data.dao.AtividadeGeologiaDAO;
import com.lab.data.dao.ParticipanteGeologiaDAO;
import com.lab.data.dao.ProjetoGeologiaDAO;
import com.lab.data.model.AreaGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.ProjetoGeologia;
import com.lab.data.service.AreaGeologiaService;
import com.lab.data.service.AtividadeGeologiaService;
import com.lab.data.service.ParticipanteGeologiaService;
import com.lab.data.service.ProjetoGeologiaService;
import com.lab.data.service.old.ArquivoService;
import com.lab.data.service.old.PesquisadorService;
import com.lab.data.service.old.ViagemService;

import framework.model.Pratica;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceAtividade;
import framework.service.interfaces.IServiceParticipante;
import framework.service.interfaces.IServiceProjeto;

@Configuration
public class ServiceConfig {
	@Bean
	public IServiceProjeto<ProjetoGeologia> projetoService() {
		return new ProjetoGeologiaService(
				new ProjetoGeologiaDAO());
	}
	
	@Bean
	public IServiceArea<AreaGeologia> localService() {
		return new AreaGeologiaService(new AreaGeologiaDAO());
	}
	
	@Bean
	public IServiceParticipante<ParticipanteGeologia> pesquisadorService() {
		return new ParticipanteGeologiaService(
				new ParticipanteGeologiaDAO());
	}
	
	@Bean
	public IServiceAtividade<PraticaGeologia> viagemService() {
		return new AtividadeGeologiaService(
				new AtividadeGeologiaDAO());
	}
	
	@Bean
	public ViagemService viagemServiceOld() {
		return new ViagemService();
	}
	
	@Bean
	public PesquisadorService pesquisadorServiceOld() {
		return new PesquisadorService();
	}
	
	@Bean
	public ArquivoService arquivoService() {
		return new ArquivoService();
	}
}
