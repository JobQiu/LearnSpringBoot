package com.qcm.learnSB13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qcm.learnSB13.dao.UserMapper;
import com.qcm.learnSB13.entity.User;

/**
 * 
 * @author Congmin Qiu 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	UserMapper userMapper;

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

		for (User u : userMapper.findAll()) {
			System.out.println(u.getId() + "->" + u.getName() + ":"
					+ u.getAge());
		}
	}
}
