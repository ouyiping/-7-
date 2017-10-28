package com.ydpay.business.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	/**审核通过状态---通过**/
	public static final  int AUDIT_STATE_PASS = 1;
	/**审核通过状态---拒绝**/
	public static final  int AUDIT_STATE_REJECT = 2;
	/**审核通过状态---待审核**/
	public static final  int AUDIT_STATE_AUTPENDING = 3;
	
	/**ydpay平台对应融合支付平台的证件类型map**/
	public final static Map<String, String> certificatetypemappingMap = new HashMap<String, String>();
	static {
		certificatetypemappingMap.put("14", "1010"); //1010-手持身份证
		certificatetypemappingMap.put("3", "1011"); //1011-身份证正面
		certificatetypemappingMap.put("4", "1012"); //1012-身份证反面
		certificatetypemappingMap.put("8", "1020"); //1020-银行卡正面
		certificatetypemappingMap.put("9", "1021"); //1021-银行卡反面
		certificatetypemappingMap.put("15", "1022"); //1022-手持银行卡正面
		certificatetypemappingMap.put("16", "1023"); //1023-信用卡正面
	}
	
}
