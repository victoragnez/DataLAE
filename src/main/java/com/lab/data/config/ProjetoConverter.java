package com.lab.data.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.ProjetoGeologia;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Projeto;
import framework.service.interfaces.IServiceProjeto;

@Component
public class ProjetoConverter implements Converter<String, Projeto<?>>{

	@Autowired
	private IServiceProjeto<ProjetoGeologia> service;
	
	@Override
	public Projeto<?> convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			ProjetoGeologia p = new ProjetoGeologia();
			p.setCodigo(id);
			List<ProjetoGeologia> pl = service.consultar(p);
			return pl.size() == 1 ? pl.get(0) : null;
		}
		catch(NumberFormatException e) {
			return null;
		} catch (DatabaseException e) {
			return null;
		} catch (BadAttributeException e) {
			return null;
		}
	}
}