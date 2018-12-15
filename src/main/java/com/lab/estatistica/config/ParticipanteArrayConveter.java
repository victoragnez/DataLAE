package com.lab.estatistica.config;

import org.springframework.stereotype.Component;

import com.lab.estatistica.model.ParticipanteEstatistica;

import java.util.ArrayList;
import org.springframework.core.convert.converter.Converter;

@Component
public class ParticipanteArrayConveter 
implements Converter<String[], ArrayList<ParticipanteEstatistica>>
{
	@Override
	public ArrayList<ParticipanteEstatistica> convert(String[] source) {
		ArrayList<ParticipanteEstatistica> participantes = new ArrayList<ParticipanteEstatistica>();
		for (int i=0; i < source.length; i++)
		{
			ParticipanteEstatistica p = new ParticipanteEstatistica();
			try {
				Integer id = Integer.valueOf(source[i]);
				p.setCodigo(id);
			} catch(NumberFormatException e) {
				p.setCodigo(null);
			}
			participantes.add(p);
		}
		return participantes;
	}

	
}
