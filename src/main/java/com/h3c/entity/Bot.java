package com.h3c.entity;

import java.util.List;

public class Bot {

    private String id;
    //private String botid;
    //private String groupName;
    //private Integer level;
    private String parentId;
    //private Integer groupSort;
    private List<Bot> children;

    public Bot(String id) {
        this.id = id;
    }

    public Bot(String id, String parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Bot(String id, String parentId, List<Bot> children) {
        this.id = id;
        this.parentId = parentId;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Bot> getChildren() {
        return children;
    }

    public void setChildren(List<Bot> children) {
        this.children = children;
    }
}
