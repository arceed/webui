package com.grokonez.spring.restapi.mysql.model;

import java.util.List;

/**
 * 树形数据实体接口
 * @author YangWenHui
 * @date 2018年4月11
 * @param <T>
 */
public interface DataTree<T> {

    public long getId();

    public long getParentId();

    public void setChildren(List<T> childList);

    public List<T> getChildren();

}
