package com.gk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.mapper.PermissionMapper;
import com.gk.model.Permission;
import com.gk.service.IPermissionService;

@Service
public class PermissionService implements IPermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getPermissionsByUserId(Integer userId) {
		return permissionMapper.getPermissionByUserId(userId);
	}

}
