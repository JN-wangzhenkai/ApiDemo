package com.example.apidemo.Bean;

/**
 * 封装数据
 * Created by wangzhenkai on 2016/6/19.
 */
public class ResultBean {

    private String _id;
    private String createdA;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;


    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCreatedA(String createdA) {
        this.createdA = createdA;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedA() {
        return createdA;
    }

    public String getDesc() {
        return desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public boolean isUsed() {
        return used;
    }

    public String getWho() {
        return who;
    }
}
