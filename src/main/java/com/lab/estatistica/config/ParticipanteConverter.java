package com.lab.estatistica.config;

import com.lab.estatistica.model.ParticipanteEstatistica;

import java.util.ArrayList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteConverter implements Converter<String, ArrayList<ParticipanteEstatistica>>{

	@Override
	public ArrayList<ParticipanteEstatistica> convert(String source) {
		ArrayList<ParticipanteEstatistica> participantes = new ArrayList<ParticipanteEstatistica>();
		ParticipanteEstatistica p = new ParticipanteEstatistica();
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
