package com.qcm.learnSB13.service.impl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcm.learnSB13.service.HighFrequencyService;
import com.qcm.learnSB13.service.SentenceService;
import com.qcm.learnSB13.service.WordService;
import com.qcm.learnSB13.util.WordUtil;

/**
 * 
 * @author Congmin Qiu 
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired
	WordService wordService;
	@Autowired
	HighFrequencyService highFrequencyService;

	private static final Set<String> NULL_SET = new HashSet<String>();

	@Override
	public Map<String, Set<String>> getSynonymsBySentence(
			String sentence) {

		List<String> wordsList = WordUtil.sentence2WordsList(sentence);
		Map<String, Set<String>> result = new LinkedHashMap<String, Set<String>>();
		for (String word : wordsList) {
			// if the word is high frequency and we don't want its synonym, such
			// as "you", we fill the value with a null set
			if (highFrequencyService.isHighFrequency(word)) {
				result.put(word, NULL_SET);
				continue;
			}
			result.put(word, wordService.getSynonymSet(word));
		}

		return result;
	}

}
