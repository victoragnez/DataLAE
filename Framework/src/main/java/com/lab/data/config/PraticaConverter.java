package com.lab.data.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.data.model.AreaGeologia;
import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Pratica;
import framework.service.interfaces.IServiceAtividade;

@Component
public class PraticaConverter implements Converter<String, Pratica<?, ?, ?>> {

	@Autowired
	private IServiceAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia, ParticipanteGeologia> service;
	
	@Override
	public Pratica<?, ?, ?> convert(String source) {
		try {
			Integer id = Integer.valueOf(source);
			PraticaGeologia p = new PraticaGeologia();
			p.setCodigo(id);
			List<PraticaGeologia> pl = service.consultar(p);
			return pl.size() == 1 ? pl.get(0) : null; 
		} catch(NumberFormatException e) {
			return null;
		} catch (DatabaseException e) {
			return null;
		} catch (BadAttributeException e) {
			return null;
		}
	}

}
