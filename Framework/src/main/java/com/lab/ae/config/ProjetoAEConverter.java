package com.lab.ae.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.ae.model.ProjetoAE;

@Component
public class ProjetoAEConverter implements Converter<String, ProjetoAE>{

	@Override
	public ProjetoAE convert(String source) {
		try {
			ProjetoAE p = new ProjetoAE();
			p.setCodigo(Integer.valueOf(source));
			return p;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
}