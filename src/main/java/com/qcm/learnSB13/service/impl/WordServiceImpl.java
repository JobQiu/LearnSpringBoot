package com.qcm.learnSB13.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcm.learnSB13.dao.WaitSynonymMapper;
import com.qcm.learnSB13.dao.WordMapper;
import com.qcm.learnSB13.entity.Word;
import com.qcm.learnSB13.service.WordService;
import com.qcm.learnSB13.util.WordUtil;

/**
 * 
 * @author Congmin Qiu 
 */
@Service
public class WordServiceImpl implements WordService {
	@Autowired
	private WordMapper wordMapper;
	@Autowired
	private WaitSynonymMapper waitSynonymMapper;

	/** use set to avoid duplicate */
	public Set<String> getSynonymSet(String word) {

		Set<String> resultSet = new HashSet<String>();
		List<Word> w = wordMapper.findSynonymsByWord(word);
		boolean isWordExisted = false;
		for (Word word2 : w) {
			if (word2 == null) {
				continue;
			}
			if(word2.getWord().trim().equals(word))
				isWordExisted = true;
			resultSet.addAll(WordUtil.getSynonymList(word2));
		}
		// if this word is only exised as a synonym or detail in other word, we
		// need to search its own synonyms
		// notice maybe later you can use mq to solve this problem, to store the
		// word into the message queue, so that you don't need to save it and
		// take it out later
		if (!isWordExisted)
			waitSynonymMapper.insertByWaitSynonym(word);

		return resultSet;
	}

}
