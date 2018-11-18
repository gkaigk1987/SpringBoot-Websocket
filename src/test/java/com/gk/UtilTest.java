package com.gk;

import org.junit.Test;

import com.gk.util.ShiroMD5Util;

public class UtilTest {

	@Test
	public void test001() {
		String code = ShiroMD5Util.encryptCode("123456", "8d78869f470951332959580424d4bf4f");
		System.out.println(code);
	}
	
}
