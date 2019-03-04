package com.grokonez.spring.restapi.mysql.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CMF_DROP_DOWN")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="NAME")
    private String name;
    @Column(name="PARENT_ID")
    private long parentId;

    @Column(name="ALIAS")
    private String alias;

    @Column(name="ROUTER")
    private String router;

    @Column(name="ICON")
    private String icon;

    @Column(name="PARENT_FLAG")
    private boolean parentFlag;

    public long getId() {
        return id;
    }


    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isParentFlag() {
        return parentFlag;
    }

    public void setParentFlag(boolean parentFlag) {
        this.parentFlag = parentFlag;
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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", alias='" + alias + '\'' +
                ", router='" + router + '\'' +
                ", icon='" + icon + '\'' +
                ", parentFlag=" + parentFlag +
                '}';
    }
}
