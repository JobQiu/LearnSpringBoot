package com.qcm.learnSB13.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcm.learnSB13.dao.HighFrequencyMapper;
import com.qcm.learnSB13.service.HighFrequencyService;

/**
 * 
 * @author Congmin Qiu 
 */
@Service
public class HighFrequencyServiceImpl implements HighFrequencyService {

	@Autowired
	HighFrequencyMapper highFrequencyMapper;

	@Override
	public boolean isHighFrequency(String word) {
		/** */
		if (highFrequencyMapper.isExisted(word) > 0) {
			return true;
		}
		return false;
	}

}
