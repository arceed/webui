package com.grokonez.spring.restapi.mysql.repo;

import com.grokonez.spring.restapi.mysql.model.RuleTree;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface RuleRepository extends CrudRepository<RuleTree, Long> {
    //List<RuleTree> findByParentId(long parentId);
    List<RuleTree> findByName(String name);
}


/*
*
ck the manual that corresponds to your MySQL server
version for the right syntax to use near
 'select, id)
 values ('BOOT_CATE', 'SCUS213', 'BOOT_CATEGORY', 5)
 ' at line 1
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)

	~[mysql-connector-java-8.0.15.jar:8.0.15]


* */