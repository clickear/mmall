package com.mmall.pojo;

public class SignTask {
    private Integer id;

    private Integer tplid;

    private Integer userid;

    private Integer disabled;

    public SignTask(Integer id, Integer tplid, Integer userid, Integer disabled) {
        this.id = id;
        this.tplid = tplid;
        this.userid = userid;
        this.disabled = disabled;
    }

    public SignTask() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTplid() {
        return tplid;
    }

    public void setTplid(Integer tplid) {
        this.tplid = tplid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}