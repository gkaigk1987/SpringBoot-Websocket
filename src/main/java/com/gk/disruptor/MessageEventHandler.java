package com.gk.disruptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;

@Component
public class MessageEventHandler implements EventHandler<MessageEvent> {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public void onEvent(MessageEvent messageEvent, long arg1, boolean arg2) throws Exception {
		System.out.println("====================" + messageEvent.getMessage().getMsg() + "===================");
		simpMessagingTemplate.convertAndSend("/topic/message", messageEvent.getMessage().getMsg());
	}

}
