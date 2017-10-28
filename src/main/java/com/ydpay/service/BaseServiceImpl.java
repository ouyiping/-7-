package com.ydpay.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ydpay.entity.MethodArgs;
import com.ydpay.entity.RetStruct;
import com.ydpay.global.GlobalContainer;
import com.ydpay.global.Validator;
import com.ydpay.provider.webinterface.base;
import com.ydpay.utils.DataValidator;
import com.ydpay.utils.MethodReflect;
import com.ydpay.utils.MgException;

public class BaseServiceImpl implements base {

	static Log log = LogFactory.getLog(BaseServiceImpl.class);

	public BaseServiceImpl() {
	}

	@Autowired
	DataValidator dataValidator;

	/**
	 * 通过openapi过来的
	 */
	public String doPost(Map<String, String> postdata) {
		RetStruct response = new RetStruct();
		try {
			MethodArgs methodargs = Validator.CheckPostMethodData(postdata, 1,
					1);
 			if (methodargs.getRet() == 0) {
				Object serviceObject = GlobalContainer.getApplicationContext()
						.getBean(methodargs.getServiceName());
				// 数据校验
				String validData = null;
				try {
					validData = dataValidator.getValidData(serviceObject,
							methodargs.getMethodName(),
							methodargs.getMethodData());
				} catch (Exception e) {
					response.setRet(18);
					response.setMessage("数据校验失败" + e.getMessage());
					return response.toString();
				}
				String session = postdata.containsKey("session") ? postdata
						.get("session") : "";
				String result = String.valueOf(MethodReflect
						.invokeMethodGernaral(serviceObject,
								methodargs.getMethodName(), new Object[] { /*
																			 * methodargs
																			 * .
																			 * getMethodData
																			 * (
																			 * )
																			 */
										validData, session }));
				return result;
			} else {
				response.setRet(methodargs.getRet());
				response.setMessage(methodargs.getMessage());
				return response.toString();
			}
		} catch (MgException ex) {
			response.setRet(ex.getRet());
			response.setMessage(ex.getMessage());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			// 只要执行的方法里有异常，都会触发此异常
			Exception target = (Exception) ex.getCause();
			if (target == null)
				target = ex;
			response.setRet(12);
			response.setMessage(target.getMessage() != null ? target
					.getMessage() : "doPost处理异常!");
			return response.toString();
		}
	}

	/**
	 * 通过其它子系统过来的
	 */
	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.masget.provider.webinterface.trustfunds#doPostForOtherSystem(java
	 * .lang.String, java.lang.String)
	 */
	public String doPostForOtherSystem(String method, String data) {
		RetStruct response = new RetStruct();
		Map<String, String> postdata = new HashMap<String, String>();
		postdata.put("method", method);
		postdata.put("data", data);

		try {
			MethodArgs methodargs = Validator.CheckPostMethodData(postdata, 0,
					0);
			if (methodargs.getRet() == 0) {
				Object serviceObject = GlobalContainer.getApplicationContext()
						.getBean(methodargs.getServiceName());
				// 数据校验
				String validData = null;
				try {
					validData = dataValidator.getValidData(serviceObject,
							methodargs.getMethodName(),
							methodargs.getMethodData());
				} catch (Exception e) {
					response.setRet(18);
					response.setMessage("数据校验失败" + e.getMessage());
					return response.toString();
				}
				
				String result = String
						.valueOf(MethodReflect.invokeMethodGernaral(
								serviceObject,
								methodargs.getMethodName(),
								new Object[] { validData,
										"call doPostForOtherSystem session is empty" }));
				return result;
			} else {
				response.setRet(methodargs.getRet());
				response.setMessage(methodargs.getMessage());
				return response.toString();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 只要执行的方法里有异常，都会触发此异常
			Exception target = (Exception) ex.getCause();
			response.setRet(12);
			response.setMessage(target.getMessage() != null ? target
					.getMessage() : "doPost处理异常!");
			return response.toString();
		}
	}
}
