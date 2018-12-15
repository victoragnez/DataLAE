package com.lab.estatistica.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.estatistica.model.AreaEstatistica;

@Component
public class LocalConverter implements Converter<String, AreaEstatistica> {

	@Override
	public AreaEstatistica convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			AreaEstatistica a = new AreaEstatistica();
			a.setCodigo(id);
			return a;
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
}
