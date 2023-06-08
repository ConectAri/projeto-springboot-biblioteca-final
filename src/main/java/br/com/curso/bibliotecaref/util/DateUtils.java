package br.com.curso.bibliotecaref.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date getDate(String data) {
		try {
			return format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
