package com.qcm.learnSB13.util;

import java.util.Date;

/**
 * 
 * @author Congmin Qiu 
 */
public class DateUtil {

	private DateUtil() {
	};


	@SuppressWarnings("deprecation")
	public static Date string2Date(String date) {
		Date d = new Date();
		if ("null".equals(date)) {
			return d;
		}

		String[] temp1 = new String[2];
		String[] temp2 = new String[3];
		if (!date.contains("CST")) {
			temp1 = date.split(" ");
			temp2 = temp1[1].split("-");
			d.setYear(Integer.parseInt(temp2[0]) - 1900);
			d.setMonth(Integer.parseInt(temp2[1]) - 1);
			d.setDate(Integer.parseInt(temp2[2]));
			return d;
		}

		d.setYear(116);
		d.setMonth(7);
		d.setDate(19);
		return new Date();
	}
}
