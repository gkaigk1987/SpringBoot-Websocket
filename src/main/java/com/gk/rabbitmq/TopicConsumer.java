package com.gk.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value="rabbit")
@Component
@RabbitListener(queues = {"topic.queue"})
public class TopicConsumer {

	@RabbitHandler
	public void consume(String msg) {
		System.out.println("=======================" + msg + "=====================");
	}
	
}
