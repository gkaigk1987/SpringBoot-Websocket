package com.gk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gk.disruptor.DisruptorManager;
import com.gk.model.Message;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private DisruptorManager disruptorManager;
	
	@RequestMapping("/")
	public String index() {
		logger.info("index 页面");
//		Message message = new Message();
//		message.setId(1);
//		message.setMsg("index 页面");
//		disruptorManager.work(message);
		return "index";
	}
	
	/**
	 * websocket测试
	 * @param text
	 * @return
	 */
	@RequestMapping(value="/ws/{text}")
	@ResponseBody
	public String testWebsocket(@PathVariable String text) {
		logger.info("websocket 消息发出");
		Message message = new Message();
		message.setId(1);
		message.setMsg(text);
		disruptorManager.work(message);
		return text;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/rwd")
	public String rwd(Model model) {
		return "rwd";
	}
	
}
