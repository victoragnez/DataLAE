package com.lab.ae.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.lab.ae.dao.AreaAEDAO;
import com.lab.ae.dao.PraticaAEDAO;
import com.lab.ae.dao.ParticipanteAEDAO;
import com.lab.ae.dao.ProjetoAEDAO;
import com.lab.ae.model.AreaAE;
import com.lab.ae.model.ParticipanteAE;
import com.lab.ae.model.PraticaAE;
import com.lab.ae.model.ProjetoAE;
import com.lab.ae.service.AreaAEService;
import com.lab.ae.service.PraticaAEService;
import com.lab.ae.service.ParticipanteAEService;
import com.lab.ae.service.ProjetoAEService;

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
	public IServiceProjeto<ProjetoAE> projetoService() {
		return new ProjetoAEService(
				new ProjetoAEDAO(null, null), new ParticipanteAEDAO(null));
	}
	
	@Bean
	public IServiceArea<AreaAE> localService() {
		return new AreaAEService(new AreaAEDAO(null));
	}
	
	@Bean
	public IServiceParticipante<ParticipanteAE> pesquisadorService() {
		return new ParticipanteAEService(
				new ParticipanteAEDAO(null));
	}
	
	@Bean
	public IServiceAtividade<AreaAE, ProjetoAE, PraticaAE> viagemService() {
		return new PraticaAEService(
				new AreaAEDAO(null), 
				new ProjetoAEDAO(null, null),
				new PraticaAEDAO(
						AreaAE.class,
						ProjetoAE.class,
						PraticaAE.class));
	}
	
	@Bean
	public IServiceArquivo<ProjetoAE, PraticaAE> arquivoService() {
		return new ServiceArquivo<>(
				new DAOArquivo<>(ProjetoAE.class, PraticaAE.class, false), 
				new ProjetoAEDAO(null, null), 
				new PraticaAEDAO(AreaAE.class, ProjetoAE.class, PraticaAE.class));
	}
}