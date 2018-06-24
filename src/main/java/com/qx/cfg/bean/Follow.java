package com.qx.cfg.bean;

import java.util.Date;

public class Follow {
    private Long id;

    private String openId;

    private Integer followOpenId;

    private String followTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getFollowOpenId() {
        return followOpenId;
    }

    public void setFollowOpenId(Integer followOpenId) {
        this.followOpenId = followOpenId;
    }

    public String getFollowTime() {
        return followTime;
    }

    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }
}