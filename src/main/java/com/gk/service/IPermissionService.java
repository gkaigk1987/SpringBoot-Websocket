package com.gk.service;

import java.util.List;

import com.gk.model.Permission;

public interface IPermissionService {

	/**
	 * 根据用户主键获取用户权限信息
	 * @param userId
	 * @return
	 */
	public List<Permission> getPermissionsByUserId(Integer userId);
	
}
