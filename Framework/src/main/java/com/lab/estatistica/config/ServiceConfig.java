package com.lab.estatistica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.estatistica.dao.AreaEstatisticaDAO;
import com.lab.estatistica.dao.ParticipanteEstatisticaDAO;
import com.lab.estatistica.dao.PraticaEstatisticaDAO;
import com.lab.estatistica.dao.ProjetoEstatisticaDAO;
import com.lab.estatistica.model.AreaEstatistica;
import com.lab.estatistica.model.ParticipanteEstatistica;
import com.lab.estatistica.model.PraticaEstatistica;
import com.lab.estatistica.model.ProjetoEstatistica;
import com.lab.estatistica.service.AreaEstatisticaService;
import com.lab.estatistica.service.ParticipanteEstatisticaService;
import com.lab.estatistica.service.PraticaEstatisticaService;
import com.lab.estatistica.service.ProjetoEstatisticaService;

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
	public IServiceProjeto<ProjetoEstatistica> projetoService() {
		return new ProjetoEstatisticaService(
				new ProjetoEstatisticaDAO(
						ProjetoEstatistica.class, 
						ParticipanteEstatistica.class), 
				new ParticipanteEstatisticaDAO(ParticipanteEstatistica.class));
	}
	
	@Bean
	public IServiceArea<AreaEstatistica> localService() {
		return new AreaEstatisticaService(new AreaEstatisticaDAO(AreaEstatistica.class));
	}
	
	@Bean
	public IServiceParticipante<ParticipanteEstatistica> pesquisadorService() {
		return new ParticipanteEstatisticaService(
				new ParticipanteEstatisticaDAO(ParticipanteEstatistica.class));
	}
	
	@Bean
	public IServiceAtividade<AreaEstatistica, ProjetoEstatistica, PraticaEstatistica> viagemService() {
		return new PraticaEstatisticaService(
				new AreaEstatisticaDAO(AreaEstatistica.class),
				new ProjetoEstatisticaDAO(ProjetoEstatistica.class, ParticipanteEstatistica.class),
				new PraticaEstatisticaDAO(
						AreaEstatistica.class, 
						ProjetoEstatistica.class,
						PraticaEstatistica.class));
	}
	
	@Bean
	public IServiceArquivo<ProjetoEstatistica, PraticaEstatistica> arquivoService() {
		return new ServiceArquivo<>(
				new DAOArquivo<>(
						ProjetoEstatistica.class, 
						PraticaEstatistica.class, 
						true), 
				new ProjetoEstatisticaDAO(
						ProjetoEstatistica.class, 
						ParticipanteEstatistica.class),
				new PraticaEstatisticaDAO(
						AreaEstatistica.class, 
						ProjetoEstatistica.class, 
						PraticaEstatistica.class));
	}
}

