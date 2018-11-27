package com.lab.data.config;

import org.springframework.stereotype.Component;

import com.lab.data.model.ParticipanteGeologia;

import java.util.ArrayList;
import org.springframework.core.convert.converter.Converter;

@Component
public class ParticipanteConverter 
implements Converter<String[], ArrayList<ParticipanteGeologia>>
{
	@Override
	public ArrayList<ParticipanteGeologia> convert(String[] source) {
		ArrayList<ParticipanteGeologia> participantes = new ArrayList<ParticipanteGeologia>();
		for (int i=0; i < source.length; i++)
		{
			ParticipanteGeologia p = new ParticipanteGeologia();
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
