package com.gk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
