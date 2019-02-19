package com.grokonez.spring.restapi.mysql.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuOption extends MenuEntity implements DataTree<MenuOption> {

    //private MenuEntity entity;
    private String icon = "el-icon-bell";
    private String alias;
    private List<MenuOption> children= new ArrayList<>();
/*

    @Override
    public long getId() {
        return this.getId();
    }

    @Override
    public long getParentId() {
        return getParentId();
    }
*/

    @Override
    public void setChildren(List<MenuOption> childList) {
        this.children = childList;
    }

    @Override
    public List<MenuOption> getChildren() {
        return children;
    }
}