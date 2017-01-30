package com.qcm.learnSB13.web;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qcm.learnSB13.service.SentenceService;

/**
 * 
 * @author Congmin Qiu 
 */
@RestController
public class ResultController {
	@Autowired
	SentenceService sentenceService;

	@RequestMapping("/result")
	public Map<String, Set<String>> result(String sentence) {
		return sentenceService.getSynonymsBySentence(sentence);
	}

	@RequestMapping("/inputReview")
	public String inputReview(String word) {
		return word;
	}
}
