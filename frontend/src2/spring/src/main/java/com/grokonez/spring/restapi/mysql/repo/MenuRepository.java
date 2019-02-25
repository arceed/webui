package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import com.grokonez.spring.restapi.mysql.model.MenuEntity;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<MenuEntity, Long> {
    List<MenuEntity> findByParentId(long parentId);
}
