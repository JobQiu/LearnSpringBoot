package com.qcm.learnSB13.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.qcm.learnSB13.Constant;
import com.qcm.learnSB13.entity.Word;

/**
 * 
 * @author Congmin Qiu 
 */
public class WordUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(WordUtil.class);
	
	private WordUtil() {
	}

	public static List<String> getSynonymList(Word word) {
		List<String> result = new ArrayList<String>();
		if (!StringUtils.isEmpty(word.getSynonym())) {
			String[] temp = word.getSynonym().split(",");
			for (String string : temp) {
				result.add(string.trim());
			}
		}

		if (!StringUtils.isEmpty(word.getDetails())) {
			String[] temp = word.getDetails().split(",");
			for (String string : temp) {
				result.add(string.trim());
			}
		}
		return result;
	}
	
	public static List<String> sentence2WordsList(String sentence) {
		for (String symbol : Constant.IGNORE_SYMBOL) {
			sentence = sentence.replace(symbol, "");
		}
		String[] temp = sentence.split(",");
		List<String> resultList = new ArrayList<String>();
		for (String string2 : temp) {
			String[] temp2 = string2.trim().split(" ");
			for (String string3 : temp2) {
				resultList.add(string3.trim());
			}
		}
		logger.info(resultList + "");
		return resultList;
	}

}
