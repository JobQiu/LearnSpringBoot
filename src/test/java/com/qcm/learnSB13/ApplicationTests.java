package com.qcm.learnSB13;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.qcm.learnSB13.dao.HighFrequencyMapper;
import com.qcm.learnSB13.dao.WaitSynonymMapper;
import com.qcm.learnSB13.dao.WordMapper;
import com.qcm.learnSB13.entity.Word;
import com.qcm.learnSB13.service.HighFrequencyService;
import com.qcm.learnSB13.service.WordService;
import com.qcm.learnSB13.util.DateUtil;
import com.qcm.learnSB13.util.WordUtil;

/**
 * @author Congmin Qiu 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	WordMapper wordMapper;
	@Autowired
	WordService wordService;
	@Autowired
	HighFrequencyMapper highFrequencyMapper;
	@Autowired
	HighFrequencyService highFrequencyService;
	@Autowired
	WaitSynonymMapper waitSynonymMapper;
	public static final Gson g = new Gson();

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Ignore
	@Test
	public void testWaitS() {

		waitSynonymMapper.deleteByWord("test");
		waitSynonymMapper.insertByWaitSynonym("tteesstt");
		Set<String> words = waitSynonymMapper.getAllWaitSynonym();
		for (String string : words) {
			System.out.println(string);
		}
	}

	@Ignore
	@Test
	public void testExisted() {
		System.out.println(highFrequencyMapper.isExisted("thu"));
		System.out.println(highFrequencyService.isHighFrequency("thus"));
		System.out.println(highFrequencyService.isHighFrequency("thu"));
	}

	@Ignore
	@Test
	public void testSentence() {
		String sentence = "you are such deem a stu-pid guy, but excel i don't radical like you";
		List<String> temp = WordUtil.sentence2WordsList(sentence);
		for (String string : temp) {
			System.out.println(string + "\t"
					+ wordService.getSynonymSet(string));
		}
	}

	@Ignore
	@Test
	public void testSynonyms() {
		Word word = wordMapper.findByWord("radical");
		System.out.println(g.toJson(word));
		System.out
				.println(word.getWord() + ":" + WordUtil.getSynonymList(word));
	}

	@Ignore
	@Test
	public void findByName() {

		// userMapper.insert("AAA", 20);
		// User u = userMapper.findByName("AAA");
		// Assert.assertEquals(20, u.getAge().intValue());

		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("name", "CCC");
		// map.put("age", 40);
		// userMapper.insertByMap(map);

		// User user = new User();
		// user.setAge(24);
		// user.setName("cmq");
		// userMapper.insertByUser(user);

		List<Word> results = wordMapper.findByUsedNumber(-2);
		Gson gson = new Gson();
		for (Word word : results) {
			System.out.print(DateUtil.string2Date(word.getDate()) + "-----");
			System.out.println(gson.toJson(word));
		}
		Word word = wordMapper.findByWord("dominant");

		System.out.print(DateUtil.string2Date(word.getDate()) + "-----");
		System.out.println(gson.toJson(word));

		Date date = new Date();
		System.out.println(date.getTime());
	}
}
