package com.lab.data.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.ProjetoGeologia;

@Component
public class ProjetoGeologiaConverter implements Converter<String, ProjetoGeologia>{

	@Override
	public ProjetoGeologia convert(String source) {
		try {
			ProjetoGeologia p = new ProjetoGeologia();
			p.setCodigo(Integer.valueOf(source));
			return p;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
}
