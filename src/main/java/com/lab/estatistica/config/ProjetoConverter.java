package com.lab.estatistica.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.estatistica.model.ProjetoEstatistica;

import framework.model.Projeto;

@Component
public class ProjetoConverter implements Converter<String, Projeto<?>>{
	
	@Override
	public Projeto<?> convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			ProjetoEstatistica p = new ProjetoEstatistica();
			p.setCodigo(id);
			return p;
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
}