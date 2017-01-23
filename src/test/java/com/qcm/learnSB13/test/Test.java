package com.qcm.learnSB13.test;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author Congmin Qiu 
 */
public class Test {
	public static void main(String[] args) {
		Integer.parseInt("ss");
		String string = "Fri Aug 19 20:34:07 CST 2016";
		System.out.println(string.contains("CST"));
		string = " you are such a stu-pid guy, but i don't like you";
		string = string.replace("-", "");
		String[] temp = string.split(",");
		List<String> resultList = new ArrayList<String>();
		for (String string2 : temp) {
			String[] temp2 = string2.trim().split(" ");
			for (String string3 : temp2) {
				resultList.add(string3.trim());
			}
		}

		System.out.println(string);
		System.out.println(resultList);
	}
}
