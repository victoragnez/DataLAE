package com.lab.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.old.Local;
import com.lab.data.service.old.LocalService;

@Component
public class LocalConverter implements Converter<String, Local> {

	@Autowired
	private LocalService service;

	@Override
	public Local convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			return service.buscarPorId(id);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
}
