package com.mmall.pojo;


import java.util.Date;


public class FileInfo {
    private Long id;

    private String fname;

    private String fsize;

    private String ext;

    private String key;

    private String mimetype;

    private Integer savetype;

    private String url;

    private Date updateTime;

    private Date createTime;


    public FileInfo(Long id, String fname, String fsize, String ext, String key, String mimetype, Integer savetype, String url, Date updateTime, Date createTime) {
        this.id = id;
        this.fname = fname;
        this.fsize = fsize;
        this.ext = ext;
        this.key = key;
        this.mimetype = mimetype;
        this.savetype = savetype;
        this.url = url;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public FileInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFsize() {
        return fsize;
    }

    public void setFsize(String fsize) {
        this.fsize = fsize == null ? null : fsize.trim();
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype == null ? null : mimetype.trim();
    }

    public Integer getSavetype() {
        return savetype;
    }

    public void setSavetype(Integer savetype) {
        this.savetype = savetype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}