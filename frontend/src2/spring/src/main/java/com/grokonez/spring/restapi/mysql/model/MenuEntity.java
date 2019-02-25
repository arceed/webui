package com.grokonez.spring.restapi.mysql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "cmf_menu_option")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="PARENT_ID")
    private long parentId;

    @Column(name="NAME")
    private String name;

    @Column(name="PARENT_FLAG")
    private boolean parentFlag;

}