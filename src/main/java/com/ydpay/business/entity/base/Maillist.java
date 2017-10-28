package com.ydpay.business.entity.base;

/**
*
* @Author auto_gen_by_tool
* @CreatedTime 2017-08-06 03:47:26
*/
public class Maillist {
     private long maillistid;
     public void setMaillistid(long maillistid) {
          this.maillistid = maillistid;
     }
     public long getMaillistid() {
          return maillistid;
     }

     private long mailgroupid;
     public void setMailgroupid(long mailgroupid) {
          this.mailgroupid = mailgroupid;
     }
     public long getMailgroupid() {
          return mailgroupid;
     }

     private String mailgroupname;
     public void setMailgroupname(String mailgroupname) {
          this.mailgroupname = mailgroupname;
     }
     public String getMailgroupname() {
          return mailgroupname;
     }

     private String mailname;
     public void setMailname(String mailname) {
          this.mailname = mailname;
     }
     public String getMailname() {
          return mailname;
     }

     private String mailaddr;
     public void setMailaddr(String mailaddr) {
          this.mailaddr = mailaddr;
     }
     public String getMailaddr() {
          return mailaddr;
     }

     private String remark;
     public void setRemark(String remark) {
          this.remark = remark;
     }
     public String getRemark() {
          return remark;
     }

     private int enableflag;
     public void setEnableflag(int enableflag) {
          this.enableflag = enableflag;
     }
     public int getEnableflag() {
          return enableflag;
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