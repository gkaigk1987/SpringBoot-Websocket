package com.gk.task.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gk.task.ILogTask;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试filebeat日志收集
 * @author Administrator
 *
 */
@Slf4j
@Component
public class LogTask implements ILogTask {

	@Override
	@Scheduled(fixedDelay = 5000)
	public void testFixedDelayLog() {
		log.info("定时生产的日志信息");
	}

}
