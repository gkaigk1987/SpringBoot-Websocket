package com.gk;

import org.junit.Test;

import com.gk.util.ShiroMD5Util;

public class UtilTest {

	@Test
	public void test001() {
		String code = ShiroMD5Util.encryptCode("123456", "admin");
		System.out.println(code);
	}
	
}
