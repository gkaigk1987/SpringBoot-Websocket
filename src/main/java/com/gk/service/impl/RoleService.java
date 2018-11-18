package com.gk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.mapper.RoleMapper;
import com.gk.model.Role;
import com.gk.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> getRolesByUserId(Integer userId) {
		return roleMapper.getRolesByUserId(userId);
	}

}
