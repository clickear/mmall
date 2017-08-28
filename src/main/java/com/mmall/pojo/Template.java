package com.mmall.pojo;

public class Template {
    private Integer id;

    private Integer userid;

    private String siteurl;

    private String sitename;

    private Integer disabled;

    private Integer interval;

    public Template(Integer id, Integer userid, String siteurl, String sitename, Integer disabled, Integer interval) {
        this.id = id;
        this.userid = userid;
        this.siteurl = siteurl;
        this.sitename = sitename;
        this.disabled = disabled;
        this.interval = interval;
    }

    public Template() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl == null ? null : siteurl.trim();
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}