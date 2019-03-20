package com.gk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/rwd")
public class RwdController {

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/rwd")
	public String rwd(Model model) {
		return "rwd/rwd";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/rwd_index")
	public String rwdIndex(Model model) {
		return "rwd/rwd_index";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/rwd_detail")
	public String rwdDetail(Model model) {
		return "rwd/rwd_detail";
	}
	
	@PostMapping("/getMessage")
	public @ResponseBody String getMessage(@RequestBody String message) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(message);
		System.out.println("进入该方法！");
		return message;
	}
	
}
