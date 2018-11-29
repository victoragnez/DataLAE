package com.lab.ae.config;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lab.ae.model.ParticipanteAE;

@Component
public class ParticipanteArrayConverter 
implements Converter<String[], ArrayList<ParticipanteAE>>
{
	@Override
	public ArrayList<ParticipanteAE> convert(String[] source) {
		ArrayList<ParticipanteAE> participantes = new ArrayList<ParticipanteAE>();
		for (int i=0; i < source.length; i++)
		{
			ParticipanteAE p = new ParticipanteAE();
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
	