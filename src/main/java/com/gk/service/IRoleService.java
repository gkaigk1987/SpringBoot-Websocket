package com.gk.service;

import java.util.List;

import com.gk.model.Role;

public interface IRoleService {

	/**
	 * 根据用户主键获取用户角色
	 * @param userId
	 * @return
	 */
	public List<Role> getRolesByUserId(Integer userId);
	
}
