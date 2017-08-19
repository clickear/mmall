package com.mmall.vo;


import java.util.Map;

/**
 * Created by Administrator on 2017/8/18.
 */
public class GitHubWebHook {
    private String ref;
    private String before;
    private String after;
    private boolean created;
    private boolean deleted;
    private boolean forced;
    private Object baseRef;
    private String compare;
    //        private HeadCommitBean headCommit;
//        private RepositoryBean repository;
//        private AuthorBean pusher;
//        private SenderBean sender;
//        private List<HeadCommitBean> commits;
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isForced() {
        return forced;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }

    public Object getBaseRef() {
        return baseRef;
    }

    public void setBaseRef(Object baseRef) {
        this.baseRef = baseRef;
    }

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }




}
