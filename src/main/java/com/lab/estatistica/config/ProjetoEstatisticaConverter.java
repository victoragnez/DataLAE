package com.lab.estatistica.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.estatistica.model.ProjetoEstatistica;

@Component
public class ProjetoEstatisticaConverter implements Converter<String, ProjetoEstatistica>{

	@Override
	public ProjetoEstatistica convert(String source) {
		try {
			ProjetoEstatistica p = new ProjetoEstatistica();
			p.setCodigo(Integer.valueOf(source));
			return p;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
}
