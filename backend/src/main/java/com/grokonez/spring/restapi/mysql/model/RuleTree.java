package com.grokonez.spring.restapi.mysql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CMF_RULES_TREE")
public class RuleTree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name="RULE_NAME")
    private String name;

    //COLUMN NAME
    @Column(name="DATA_NAME")
    private String column;

    @Column(name="ALIAS")
    private String alias;

}


/*
*
* CREATE TABLE `CMF_RULES_TREE` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RULE_NAME` varchar(45) DEFAULT NULL,
  `SELECT` varchar(45) DEFAULT NULL,
  `ALIAS` varchar(45) DEFAULT NULL,
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

* */
