package com.lab.estatistica.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.estatistica.model.PraticaEstatistica;

import framework.model.Pratica;

@Component
public class PraticaConverter implements Converter<String, Pratica<?, ?, ?>> {
	
	@Override
	public Pratica<?, ?, ?> convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			PraticaEstatistica p = new PraticaEstatistica();
			p.setCodigo(id);
			return p; 
		} catch(NumberFormatException e) {
			return null;
		}
	}

}
