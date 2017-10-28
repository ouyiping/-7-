package com.ydpay.service;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ydpay.dao.cache.InitCache;
import com.ydpay.global.GlobalContainer;
import com.ydpay.utils.ServerParamsUtil;

/**
 * Hello world!
 * 
 */
public class BaseApp {
	static Log log = LogFactory.getLog(BaseApp.class);

	public static void main(String[] args) throws Exception {
		log.info("初始化redis的配置......");
		InitCache.InitPoolConfig();
		log.info("初始化redis的完成");
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		applicationContext.start();
		GlobalContainer.setApplicationContext(applicationContext);

//		ServerParamsUtil.init(0);
//		MasgetSessioninfoServiceImpl masgetSessioninfoServiceImpl = (MasgetSessioninfoServiceImpl) GlobalContainer
//				.getApplicationContext()
//				.getBean("masgetSessioninfoServiceImpl");
//		masgetSessioninfoServiceImpl.loadSessioninfoMasget("", null);
//		//加载平台固定session
//		PlatfromSessioninfoServiceImpl platfromSessioninfoServiceImpl = (PlatfromSessioninfoServiceImpl) GlobalContainer
//				.getApplicationContext()
//				.getBean("platfromSessioninfoServiceImpl");
//		platfromSessioninfoServiceImpl.loadSessioninfoPlatfrom("{}", null);
//		//加载子系统对接信息
//		SystemDockingServiceImpl systemDockingServiceImpl = (SystemDockingServiceImpl) GlobalContainer
//				.getApplicationContext()
//				.getBean("systemDockingServiceImpl");
//		systemDockingServiceImpl.loadDockingSystem("{}", null);
		log.info("========================================================================================");
		log.info("---------------start base-service-provider sucessful---------------------");
		try {
			System.in.read();
		} catch (IOException e) {
			log.error(e, e);
		}
	}

}
