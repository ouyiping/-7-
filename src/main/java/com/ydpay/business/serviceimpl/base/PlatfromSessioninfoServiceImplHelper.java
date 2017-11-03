package com.ydpay.business.serviceimpl.base;

import com.alibaba.fastjson.JSONObject;
import com.ydpay.cache.redis.RedisCache;
import com.ydpay.global.tf_session;
import com.ydpay.utils.RedisKeyUtil;


public class PlatfromSessioninfoServiceImplHelper {

	/**
	 * 保存session
	 * @param sessionid
	 * @return
	 */
	public static boolean saveSession(tf_session session) {
		return RedisCache.getInstance().set(RedisKeyUtil.SESSION_PREFIX + session.getSession(),
				JSONObject.toJSONString(session), 0);
	}
	
	public static void logout(tf_session session) {
		RedisCache.getInstance().remove(RedisKeyUtil.SESSION_PREFIX + session.getSession());
	}

}
