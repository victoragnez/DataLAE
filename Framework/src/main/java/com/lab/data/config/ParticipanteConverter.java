package com.lab.data.config;

import com.lab.data.model.ParticipanteGeologia;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteConverter implements Converter<String, List<ParticipanteGeologia>>{

	@Override
	public List<ParticipanteGeologia> convert(String source) {
		ArrayList<ParticipanteGeologia> participantes = new ArrayList<ParticipanteGeologia>();
		ParticipanteGeologia p = new ParticipanteGeologia();
		try {
			Integer id = Integer.valueOf(source);
			p.setCodigo(id);
		} catch(NumberFormatException e) {
			p.setCodigo(null);
		}
		participantes.add(p);
		return participantes;
	}	

}
