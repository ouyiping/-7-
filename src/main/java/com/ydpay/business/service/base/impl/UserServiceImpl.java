package com.ydpay.business.service.base.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.ydpay.business.dao.base.UserDao;
import com.ydpay.business.service.base.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger =Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Override
	public List<Map<String, Object>> selUsers(JSONObject obj) throws Exception{
		List<Map<String, Object>> list = userDao.select(obj, null, null, null);
		return list;
	}
	@Transactional
	@Override
	public JSONObject insertUser(JSONObject obj) throws Exception{
		obj.put("userid", 1);
		userDao.insert(obj);
		return obj;
	}

}
