package com.ydpay.business.test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ydpay.business.utils.MD5Util;
import com.ydpay.business.utils.security.AesEncryption;
import com.ydpay.business.utils.security.ApiUtil;
import com.ydpay.business.utils.security.HttpsUtil;
import com.ydpay.utils.MaxIdUtil;

public class TestMain {

	public static void main(String[] args) throws Exception {
		//本地接口连接测试
//		String openApiUrl = "https://127.0.0.1:7786/openapi/rest";
//		String appid = "600987967";
//		String session = "6l903uszzfme72z1ya533w7b6mj9i246";
//		String secretkey = "fxgmv564v45mujh3";
//		String method = "masget.base.com.user.selusers";
//		String data = "{\"companyid\":\"600936755\",\"companyname\":\"荣邦科技有限公司\",\"subcompanyid\":\"1001010\",\"subcompanyname\":\"子商户\",\"payorderid\":\"303108271340541251\",\"ordernumber\":\"30100105151151\",\"businesstype\":\"1001\",\"paymenttypeid\":\"4\",\"paymenttypename\":\"银联在线\",\"body\":\"收款\",\"amount\":\"1000\",\"businesstime\":\"2016-08-24 13:10:66\",\"respcode\":\"2\",\"respmsg\":\"支付成功\"}";
//		String retstr = ApiUtil.methodInvoke(openApiUrl, appid, session, secretkey, method, data);
//		System.out.println(retstr);
		
		
		//本地接口连接测试
//		String openApiUrl = "https://127.0.0.1:7786/base/com/user/selusers";
//		String appid = "400532784";
//		String secretkey = "NiAYLFyxze2yeK5N";
//		String data = "{\"body\":\"物业管理方[2017-06(租金)]\",\"subcompanyname\":\"华府山水\",\"channelpayorderid\":\"4001602001201706308137294824\",\"subcompanyid\":600988774,\"rcompanyname\":\"华府山水\",\"ordernumber\":\"6012017063015000001\",\"paymenttypename\":\"微信\",\"respmsg\":\"支付成功\",\"amount\":1,\"loginname\":\"test77777\",\"companyid\":600988774,\"stationid\":600988775,\"rcompanyid\":600988774}";
//		String retstr = HttpsUtil.doSslPost(openApiUrl, makeReportBackQueryParams(data, secretkey, "paymentreport", appid), "utf-8");
//		System.out.println(retstr);

		//获取insert主键
		System.out.println(MaxIdUtil.getUUIDPrimaryKey());
		
	}
	
	public static String makeReportBackQueryParams(String data, String secretkey, String method, String Appid)
		throws Exception {
		String base64Data = AesEncryption.Encrypt(data, secretkey, secretkey);
		String sign = MD5Util.toMD5(base64Data + secretkey);
		String result =  "Data=" + base64Data + "&Sign=" + sign+"&Method="+method+"&Appid="+Appid;
		System.out.println(result);
		return result;
	}
	
//	public void addOrder(){
//		//社区编号
//		String communityid = "100011";
//		//时间戳
//		String tick = System.currentTimeMillis()+"";
//		//社区名称
//		String communityname = "华府山水";
//		String token = MD5Util.toMD5(communityid+tick+communityname);
//		System.out.println("token="+token);
//		
//		Map<String, Object> urlParamMap = new HashMap<String, Object>();
//		urlParamMap.put("neibor_flag", communityid);
//		urlParamMap.put("tick", tick);
//		urlParamMap.put("data", "json");
//		
//		//String url  = "http://gdsayee.cn:9094/yin_lian/save_expenses.json";
//		String url="http://gdsayee.cn:8084/yin_lian/save_expenses.json";
//		
//		String res = HttpPostHelper.sendHTTPPost(token,urlParamMap,url);
//
//		System.out.println("返回消息:"+res);
//	}
}
