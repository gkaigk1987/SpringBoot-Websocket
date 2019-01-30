package com.gk.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 * 用户登录 
	 * 此处不做真正的登录，真正的登录由Shiro提供
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model) {
		String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(LockedAccountException.class.getName().equals(exceptionClassName)) {
        	error = "该账户已被锁定";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
		return "login";
	}
	
	/**
	 * 用户推出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "login";
	}
}
