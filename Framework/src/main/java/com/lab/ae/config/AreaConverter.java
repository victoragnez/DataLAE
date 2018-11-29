package com.lab.ae.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.ae.model.AreaAE;


import framework.service.interfaces.IServiceArea;


@Component
public class AreaConverter implements Converter<String, AreaAE>{

	@Autowired
	private IServiceArea<AreaAE> service;
	
	@Override
	public AreaAE convert(String source) {
		
		try {
			Integer id = Integer.valueOf(source);
			AreaAE a = new AreaAE();
			a.setCodigo(id);
			List<AreaAE> list = service.consultar(a);
			return list.get(0); 
		}
		catch(Exception e) {
			return null;
		}
	}

}
