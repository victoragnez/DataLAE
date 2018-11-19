package com.lab.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.old.Projeto;
import com.lab.data.service.old.ProjetoService;

@Component
public class ProjetoConverter implements Converter<String, Projeto>{

	@Autowired
	private ProjetoService service;
	
	@Override
	public Projeto convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			return service.buscarPorId(id);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
}