package com.qcm.learnSB13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Congmin Qiu 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestMail {

	@Autowired
	private JavaMailSender javaMailSender;

	@Test
	public void sendSimpleEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("cmqiu@seeiner.com");
		message.setTo("qcm3771787@163.com");
		message.setSubject("this is a tteesstt");
		message.setText("only a tteesstt, dont worry");

		javaMailSender.send(message);

	}
}
