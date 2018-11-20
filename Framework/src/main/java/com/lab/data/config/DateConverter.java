package com.lab.data.config;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		System.out.println(Date.valueOf(source));
		return Date.valueOf(source);
	}
}
