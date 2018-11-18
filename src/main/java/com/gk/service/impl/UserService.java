package com.gk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.mapper.UserMapper;
import com.gk.model.User;
import com.gk.model.UserExample;
import com.gk.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getUserByUserName(String userName) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		List<User> list = userMapper.selectByExample(example);
		if(null != list) {
			return list.get(0);
		}
		return null;
	}

}
