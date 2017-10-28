package com.ydpay.business.serviceimpl.base;

import com.alibaba.fastjson.JSONObject;
import com.ydpay.business.entity.base.Companyinfo;
import com.ydpay.business.entity.base.Companystaff;
import com.ydpay.business.entity.base.Memberinfo;
import com.ydpay.business.entity.base.Membermerchant;
import com.ydpay.business.entity.base.Platfromsessioninfo;
import com.ydpay.cache.redis.RedisCache;
import com.ydpay.enums.base.DeviceType;
import com.ydpay.global.tf_session;
import com.ydpay.utils.ObjectParser;
import com.ydpay.utils.RedisKeyUtil;
import com.ydpay.utils.StringUtil;
import com.ydpay.utils.TimeUtil;


public class PlatfromSessioninfoServiceImplHelper {

	public static tf_session makeSession(Companyinfo companyinfo,
			Memberinfo memberinfo, Companystaff companystaff,
			Membermerchant membermerchant) {
		
		tf_session session = new tf_session();
		
		session.setCompanyinfo(companyinfo);
		session.setStaffid(companystaff.getStaffid());
		session.setStaffname(companystaff.getStaffname());
		session.setStafftype(companystaff.getStafftype());
		session.setRoleresourceid(companystaff.getRoleresourceid());
		session.setAgentstaffid(companystaff.getAgentstaffid());
		session.setAgentstaffname(companystaff.getAgentstaffname());
		
		session.setMembermerchant(membermerchant);
		memberinfo.setLoginpwd(null);
		memberinfo.setPwdkey(null);
		session.setAppid(memberinfo.getMemberid() + "");
		session.setAppname(memberinfo.getMembername());
		session.setMobilephone(memberinfo.getMobilephone());
		session.setSession(StringUtil.getKey(32, 32));
		session.setSecretkey(StringUtil.getKey(StringUtil.ALL_LETTER_AND_NUMBER, 16, 16));
		session.setLogintime(TimeUtil.getTimestamp());
		session.setLastusetime(TimeUtil.getTimestamp());
		session.setMemberid(memberinfo.getMemberid());
		session.setMembername(memberinfo.getMembername());
		session.setMembertype(memberinfo.getMembertype());
		session.setDevicetype(DeviceType.PC.getCode());
		session.setMemberlevel(memberinfo.getMemberlevel());
		session.setCertflag(memberinfo.getCertflag());
		
		return session;
	}

	
	public static Platfromsessioninfo makeInsert(
			Platfromsessioninfo platfromsessioninfo, tf_session session) {	
		
		//保存到数据库
		platfromsessioninfo.setAppid(ObjectParser.toLong(session.getAppid()));
		platfromsessioninfo.setAppname(session.getAppname());
		platfromsessioninfo.setCompanyid(ObjectParser.toLong(session.getCompanyinfo().getCompanyid()));
		platfromsessioninfo.setCompanyname(session.getCompanyinfo().getCompanyname());
		platfromsessioninfo.setMemberid(ObjectParser.toLong(session.getMemberid()));
		platfromsessioninfo.setMembername(session.getMembername());
		platfromsessioninfo.setMobilephone(session.getMobilephone());
		platfromsessioninfo.setStaffid(session.getStaffid());
		platfromsessioninfo.setStaffname(session.getStaffname());
		platfromsessioninfo.setSession(session.getSession());
		platfromsessioninfo.setSecretkey(session.getSecretkey());
		platfromsessioninfo.setSessioninfo(JSONObject.toJSONString(session));
		
		return platfromsessioninfo;
	}
	
	
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
