package com.gk.disruptor;

import java.util.concurrent.ThreadFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gk.model.Message;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

@Component
public class DisruptorManager {

	private static Logger logger = LoggerFactory.getLogger(DisruptorManager.class);
	
//	private ExecutorService executorService = null;
	
	private Disruptor<MessageEvent> disruptor;
	
	private RingBuffer<MessageEvent> ringBuffer;
	
	/**
	 * 方法一
	 * 测试通过
	 * @param messageEventHandler
	 */
	/*@Autowired
	public DisruptorManager(MessageEventHandler messageEventHandler) {
		logger.info("初始化Disruptor开始。。。");
//		executorService = Executors.newCachedThreadPool();
//		MessageEventHandler handler = new MessageEventHandler();
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,"MESSAGE-PUBLISH-THREAD");
			}
		};
//		disruptor = new Disruptor<MessageEvent>(new MessageEventFactory(), 8 * 1024, executorService, ProducerType.MULTI, new BlockingWaitStrategy());
		disruptor = new Disruptor<MessageEvent>(new MessageEventFactory(), 8 * 1024, threadFactory, ProducerType.MULTI, new BlockingWaitStrategy());
		ringBuffer = disruptor.getRingBuffer();
		disruptor.handleEventsWith(messageEventHandler);
		disruptor.start();
		logger.info("初始化Disruptor结束。。。");
	}*/
	
	@Autowired
	private MessageEventHandler messageEventHandler;
	
	/**
	 * 方法二
	 * 测试通过
	 */
	@PostConstruct
	public void init() {
		logger.info("初始化Disruptor开始。。。");
//		executorService = Executors.newCachedThreadPool();
//		MessageEventHandler handler = new MessageEventHandler();
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,"MESSAGE-PUBLISH-THREAD");
			}
		};
//		disruptor = new Disruptor<MessageEvent>(new MessageEventFactory(), 8 * 1024, executorService, ProducerType.MULTI, new BlockingWaitStrategy());
		disruptor = new Disruptor<MessageEvent>(new MessageEventFactory(), 8 * 1024, threadFactory, ProducerType.MULTI, new BlockingWaitStrategy());
		ringBuffer = disruptor.getRingBuffer();
		disruptor.handleEventsWith(messageEventHandler);
		disruptor.start();
		logger.info("初始化Disruptor结束。。。");
	}
	
	@PreDestroy
	public void destroy() {
		if(disruptor != null) {
			disruptor.shutdown();
		}
	}
	
	public void work(Message message) {
		if(null == ringBuffer) {
			return;
		}
		long next = ringBuffer.next();
		try {
			MessageEvent messageEvent = ringBuffer.get(next);
			messageEvent.setMessage(message);
		} finally {
			ringBuffer.publish(next);
		}
	}
	
}
