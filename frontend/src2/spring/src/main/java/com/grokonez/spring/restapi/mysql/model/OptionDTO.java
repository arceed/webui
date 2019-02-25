package com.grokonez.spring.restapi.mysql.model;

import java.util.List;

public class OptionDTO {
    private int id;
    private String name;
    private int parentId;
    private boolean parentFlag;
    List<OptionDTO> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isParentFlag() {
        return parentFlag;
    }

    public void setParentFlag(boolean parentFlag) {
        this.parentFlag = parentFlag;
    }
}
