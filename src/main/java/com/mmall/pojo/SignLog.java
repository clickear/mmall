package com.mmall.pojo;

import java.util.Date;

public class SignLog {
    private Integer id;

    private Date createtime;

    private Integer tplid;

    private String sitename;

    private String content;

    public SignLog(Integer id, Date createtime, Integer tplid, String sitename, String content) {
        this.id = id;
        this.createtime = createtime;
        this.tplid = tplid;
        this.sitename = sitename;
        this.content = content;
    }

    public SignLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getTplid() {
        return tplid;
    }

    public void setTplid(Integer tplid) {
        this.tplid = tplid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}