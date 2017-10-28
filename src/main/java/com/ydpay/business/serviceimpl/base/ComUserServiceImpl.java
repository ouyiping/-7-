package com.ydpay.business.serviceimpl.base;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ydpay.business.service.base.UserService;
import com.ydpay.entity.RetStruct;
import com.ydpay.global.SessionManager;
import com.ydpay.global.tf_session;
import com.ydpay.utils.MgException;

@Controller
public class ComUserServiceImpl {
	@Autowired
	private UserService userService;
	
	public String selusersUserCom(String data, String sessionid) {
		// tag = base.com.user.selusers 
		JSONObject jsonObject = null;
		RetStruct retMap = new RetStruct();
		try {
			jsonObject = JSONObject.parseObject(data);
			List<Map<String,Object>> list = userService.selUsers(jsonObject);
			return new RetStruct("查询成功", "data",
					JSONObject.toJSON(list)).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("非法json格式参数");
			return retMap.toString();
		} catch (MgException e) {
			retMap.put("ret", -1);
			retMap.setMessage(e.getMessage());
			return retMap.toString();
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("程序异常");
			return retMap.toString();
		}
	}
	
	public String addUserCom(String data, String sessionid) {
		// tag = base.com.user.add
		JSONObject jsonObject = null;
		RetStruct retMap = new RetStruct();
		try {
			jsonObject = JSONObject.parseObject(data);
			JSONObject obj  = userService.insertUser(jsonObject);
			return new RetStruct("插入成功", "data",
					JSONObject.toJSON(obj)).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("非法json格式参数");
			return retMap.toString();
		} catch (MgException e) {
			retMap.put("ret", -1);
			retMap.setMessage(e.getMessage());
			return retMap.toString();
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("程序异常");
			return retMap.toString();
		}
	}
	
	/**
	 * 设置session测试
	 * @param data
	 * @param sessionid
	 * @return
	 */
	public String setsessionUserCom(String data, String sessionid) {
		// tag = base.com.user.setsession
		JSONObject jsonObject = null;
		RetStruct retMap = new RetStruct();
		try {
			jsonObject = JSONObject.parseObject(data);
			tf_session session = new tf_session();
			session.setSession(UUID.randomUUID().toString().replace("-", ""));
			session.setMemberid(10001);
			session.setMembername("ouyp");
			SessionManager.getInstance().saveSession(session);
			return new RetStruct("设置session测试", "data",
					JSONObject.toJSON(session)).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("非法json格式参数");
			return retMap.toString();
		} catch (MgException e) {
			retMap.put("ret", -1);
			retMap.setMessage(e.getMessage());
			return retMap.toString();
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("程序异常");
			return retMap.toString();
		}
	}
	
	/**
	 * 获取session测试
	 * @param data
	 * @param sessionid
	 * @return
	 */
	public String getsessionUserCom(String data, String sessionid) {
		// tag = base.com.user.getsession
		JSONObject jsonObject = null;
		RetStruct retMap = new RetStruct();
		try {
			jsonObject = JSONObject.parseObject(data);
			tf_session session = SessionManager.getInstance().getSession(sessionid);
			return new RetStruct("获取session测试", "data",
					JSONObject.toJSON(session)).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("非法json格式参数");
			return retMap.toString();
		} catch (MgException e) {
			retMap.put("ret", -1);
			retMap.setMessage(e.getMessage());
			return retMap.toString();
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("ret", -1);
			retMap.setMessage("程序异常");
			return retMap.toString();
		}
	}
}
