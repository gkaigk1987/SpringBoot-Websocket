package com.gk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gk.model.User;
import com.gk.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//
//	@Test
//	public void test001() {
//		rabbitTemplate.convertAndSend("topic.exchange", "spring.test", "Hello RabbitMQ");
//	}
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void test001() {
		User user = userService.getUserByUserName("admin");
		System.out.println(user.getUsername());
	}
}
