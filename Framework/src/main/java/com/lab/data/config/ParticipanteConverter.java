package com.lab.data.config;

import com.lab.data.model.ParticipanteGeologia;
import java.util.ArrayList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteConverter implements Converter<String, ArrayList<ParticipanteGeologia>>{

	@Override
	public ArrayList<ParticipanteGeologia> convert(String source) {
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
