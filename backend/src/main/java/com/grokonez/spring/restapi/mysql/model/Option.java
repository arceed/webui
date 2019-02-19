package com.grokonez.spring.restapi.mysql.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cmf_drop_down")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int parentId;
    private boolean parentFlag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
