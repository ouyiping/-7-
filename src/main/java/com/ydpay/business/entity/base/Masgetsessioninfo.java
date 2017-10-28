package com.ydpay.business.entity.base;

/**
*
* @Author auto_gen_by_tool
* @CreatedTime 2017-08-06 03:41:59
*/
public class Masgetsessioninfo {
     private long masgetsessioninfoid;
     public void setMasgetsessioninfoid(long masgetsessioninfoid) {
          this.masgetsessioninfoid = masgetsessioninfoid;
     }
     public long getMasgetsessioninfoid() {
          return masgetsessioninfoid;
     }

     private long companyid;
     public void setCompanyid(long companyid) {
          this.companyid = companyid;
     }
     public long getCompanyid() {
          return companyid;
     }

     private String companyname;
     public void setCompanyname(String companyname) {
          this.companyname = companyname;
     }
     public String getCompanyname() {
          return companyname;
     }

     private long appid;
     public void setAppid(long appid) {
          this.appid = appid;
     }
     public long getAppid() {
          return appid;
     }

     private String appname;
     public void setAppname(String appname) {
          this.appname = appname;
     }
     public String getAppname() {
          return appname;
     }

     private String session;
     public void setSession(String session) {
          this.session = session;
     }
     public String getSession() {
          return session;
     }

     private String key;
     public void setKey(String key) {
          this.key = key;
     }
     public String getKey() {
          return key;
     }

     private String apiurl;
     public void setApiurl(String apiurl) {
          this.apiurl = apiurl;
     }
     public String getApiurl() {
          return apiurl;
     }

     private int enableflag;
     public void setEnableflag(int enableflag) {
          this.enableflag = enableflag;
     }
     public int getEnableflag() {
          return enableflag;
     }

     private String createtime;
     public void setCreatetime(String createtime) {
          this.createtime = createtime;
     }
     public String getCreatetime() {
          return createtime;
     }

     private String begincreatetime;
     public void setBegincreatetime(String begincreatetime) {
          this.begincreatetime = begincreatetime;
     }
     public String getBegincreatetime() {
          return begincreatetime;
     }

     private String endcreatetime;
     public void setEndcreatetime(String endcreatetime) {
          this.endcreatetime = endcreatetime;
     }
     public String getEndcreatetime() {
          return endcreatetime;
     }
     private long tunnelcode ;
     private String  tunnelname;
     
     public long getTunnelcode() {
		return tunnelcode;
	}
	public void setTunnelcode(long tunnelcode) {
		this.tunnelcode = tunnelcode;
	}
	

	public String getTunnelname() {
		return tunnelname;
	}
	public void setTunnelname(String tunnelname) {
		this.tunnelname = tunnelname;
	}

	private int pagesize;
     public void setPagesize(int pagesize) {
          this.pagesize = pagesize;
     }
     public int getPagesize() {
          return pagesize;
     }

     private int pagenum;
     public void setPagenum(int pagenum) {
          this.pagenum = pagenum;
     }
     public int getPagenum() {
          return pagenum;
     }

}