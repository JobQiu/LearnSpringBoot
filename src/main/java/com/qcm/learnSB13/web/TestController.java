package com.qcm.learnSB13.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qcm.learnSB13.dao.WordMapper;
import com.qcm.learnSB13.entity.Word;
import com.qcm.learnSB13.service.WordService;

/**
 * 
 * @author Congmin Qiu 
 */
@Controller
public class TestController {
	@Autowired
	WordService wordService;
	@Autowired
	WordMapper wordMapper;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		Word word = wordMapper.findByWord("consistent");
		modelAndView.addObject("word", word);
		modelAndView.addObject("words", wordMapper.findByUsedNumber(1));
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/synonym")
	public String synonym(String sentence) {
		System.out.println(sentence);
		return "index";
	}
}
