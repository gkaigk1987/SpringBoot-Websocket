package com.gk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void test001() {
		rabbitTemplate.convertAndSend("topic.exchange", "spring.test", "Hello RabbitMQ");
	}
	
}
