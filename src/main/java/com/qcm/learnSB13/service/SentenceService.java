package com.qcm.learnSB13.service;

import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Congmin Qiu 
 */
public interface SentenceService {

	public Map<String, Set<String>> getSynonymsBySentence(
			String sentence);
}
