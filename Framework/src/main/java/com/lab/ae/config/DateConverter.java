package com.lab.ae.config;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			return Date.valueOf(source);
		}
		catch(IllegalArgumentException e) {
			return null;
		}
	}
}