package com.gk.service;

import com.gk.model.User;

public interface IUserService {

	/**
	 * 根据用户主键获取用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 根据用户账户获取用户信息
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	
}
