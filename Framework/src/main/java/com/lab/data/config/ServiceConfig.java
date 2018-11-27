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

import framework.dao.DAOArquivo;
import framework.service.ServiceArquivo;
import framework.service.interfaces.IServiceArea;
import framework.service.interfaces.IServiceArquivo;
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
	public IServiceAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia> viagemService() {
		return new AtividadeGeologiaService(
				new AreaGeologiaDAO(), 
				new ProjetoGeologiaDAO(),
				new AtividadeGeologiaDAO(
						AreaGeologia.class,
						ProjetoGeologia.class,
						PraticaGeologia.class));
	}
	
	@Bean
	public IServiceArquivo<ProjetoGeologia, PraticaGeologia> arquivoService() {
		return new ServiceArquivo<>(
				new DAOArquivo<>(ProjetoGeologia.class, PraticaGeologia.class), 
				new ProjetoGeologiaDAO(), 
				new AtividadeGeologiaDAO(AreaGeologia.class, ProjetoGeologia.class, PraticaGeologia.class));
	}
}
