package com.grokonez.spring.restapi.mysql.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class MenuItem implements DataTree<MenuItem> {

    private MenuEntity entity;

    private List<MenuItem> children= new ArrayList<>();


    @Override
    public long getId() {
        return entity.getId();
    }

    @Override
    public long getParentId() {
        return entity.getParentId();
    }

    @Override
    public void setChildren(List<MenuItem> childList) {
        this.children = childList;
    }

    @Override
    public List<MenuItem> getChildren() {
        return children;
    }
}