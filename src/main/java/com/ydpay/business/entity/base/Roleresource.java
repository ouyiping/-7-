package com.ydpay.business.entity.base;

/**
*
* @Author auto_gen_by_tool
* @CreatedTime 2017-08-25 18:33:45
*/
public class Roleresource {
     private long roleresourceid;
     public void setRoleresourceid(long roleresourceid) {
          this.roleresourceid = roleresourceid;
     }
     public long getRoleresourceid() {
          return roleresourceid;
     }

     private long presourceid;
     public void setPresourceid(long presourceid) {
          this.presourceid = presourceid;
     }
     public long getPresourceid() {
          return presourceid;
     }

     private String presourcename;
     public void setPresourcename(String presourcename) {
          this.presourcename = presourcename;
     }
     public String getPresourcename() {
          return presourcename;
     }

     private long resourceid;
     public void setResourceid(long resourceid) {
          this.resourceid = resourceid;
     }
     public long getResourceid() {
          return resourceid;
     }

     private String resourcename;
     public void setResourcename(String resourcename) {
          this.resourcename = resourcename;
     }
     public String getResourcename() {
          return resourcename;
     }

     private long resourcelevel;
     public void setResourcelevel(long resourcelevel) {
          this.resourcelevel = resourcelevel;
     }
     public long getResourcelevel() {
          return resourcelevel;
     }

     private long createdby;
     public void setCreatedby(long createdby) {
          this.createdby = createdby;
     }
     public long getCreatedby() {
          return createdby;
     }

     private String createname;
     public void setCreatename(String createname) {
          this.createname = createname;
     }
     public String getCreatename() {
          return createname;
     }

     private String createdtime;
     public void setCreatedtime(String createdtime) {
          this.createdtime = createdtime;
     }
     public String getCreatedtime() {
          return createdtime;
     }

     private String begincreatedtime;
     public void setBegincreatedtime(String begincreatedtime) {
          this.begincreatedtime = begincreatedtime;
     }
     public String getBegincreatedtime() {
          return begincreatedtime;
     }

     private String endcreatedtime;
     public void setEndcreatedtime(String endcreatedtime) {
          this.endcreatedtime = endcreatedtime;
     }
     public String getEndcreatedtime() {
          return endcreatedtime;
     }

     private int enableflag;
     public void setEnableflag(int enableflag) {
          this.enableflag = enableflag;
     }
     public int getEnableflag() {
          return enableflag;
     }
     private String weburl;
     
     public String getWeburl() {
		return weburl;
	}
	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}
	private long weight;
	private String icon;
	

	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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