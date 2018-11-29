package com.lab.data.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.AreaGeologia;

import framework.service.interfaces.IServiceArea;

@Component
public class LocalConverter implements Converter<String, AreaGeologia> {

	@Autowired
	private IServiceArea<AreaGeologia> service;

	@Override
	public AreaGeologia convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			AreaGeologia a = new AreaGeologia();
			a.setCodigo(id);
			List<AreaGeologia> list = service.consultar(a);
			return list.get(0); 
		}
		catch(Exception e) {
			return null;
		}
	}
}
