package com.gk.disruptor;

import com.gk.model.Message;

public class MessageEvent {
	
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
}
