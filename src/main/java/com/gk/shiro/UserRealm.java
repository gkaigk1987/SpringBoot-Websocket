package com.gk.shiro;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gk.model.Permission;
import com.gk.model.Role;
import com.gk.model.User;
import com.gk.service.IPermissionService;
import com.gk.service.IRoleService;
import com.gk.service.IUserService;

/**
 * 用户Realm
 * @author Administrator
 *
 */
public class UserRealm extends AuthorizingRealm {
	
	private static Logger logger = LoggerFactory.getLogger(UserRealm.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("=====================用户授权开始==================");
		User user = (User)principals.getPrimaryPrincipal();
		List<Role> roles = roleService.getRolesByUserId(user.getId());
		List<Permission> permissions = permissionService.getPermissionsByUserId(user.getId());
		//用户角色
		List<String> roleNameList = roles.stream().map(r -> {
			return r.getName();
		}).collect(Collectors.toList());
		//用户权限
		List<String> permissionNameList = permissions.stream().map(p -> {
			return p.getPermission();
		}).collect(Collectors.toList());
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRoles(roleNameList);
		simpleAuthorizationInfo.addStringPermissions(permissionNameList);
		logger.info("=====================用户授权结束==================");
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("=====================用户认证开始==================");
		String userName = (String) token.getPrincipal();
		logger.info("认证用户账户名为：{}",userName);
		User user = userService.getUserByUserName(userName);
		if(null == user) {
			logger.warn("系统不存在账户名为{}的账户",userName);
			throw new UnknownAccountException();//不存在该账号
		}
		String state = user.getState();
		if("0".equals(state)) {
			logger.warn("账户名为{}的账户已被系统锁定，暂时不能使用",userName);
			throw new LockedAccountException();//账号被锁定
		}
		//此处可以获取用户菜单进行设置
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), 
				ByteSource.Util.bytes(user.getSalt()), this.getName()); 
		logger.info("=====================用户认证结束==================");
		return simpleAuthenticationInfo;
	}

}
