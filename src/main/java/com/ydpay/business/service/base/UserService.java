package com.ydpay.business.service.base;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
	public List<Map<String,Object>> selUsers(JSONObject obj);
	public JSONObject insertUser(JSONObject obj);
}
