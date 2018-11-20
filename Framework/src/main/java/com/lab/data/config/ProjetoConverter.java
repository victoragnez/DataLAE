package com.lab.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.ProjetoGeologia;

import framework.service.ServiceProjeto;

@Component
public class ProjetoConverter implements Converter<String, ProjetoGeologia>{

	@Autowired
	private ServiceProjeto<ProjetoGeologia> service;
	
	@Override
	public ProjetoGeologia convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			ProjetoGeologia p = new ProjetoGeologia();
			p.setCodigo(id);
			return service.buscar(p);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
}