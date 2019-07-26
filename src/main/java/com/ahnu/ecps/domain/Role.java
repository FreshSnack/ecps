package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 角色
 * @Author: mxding
 * @Date: 2019-07-24 10:15
 */
@Getter
@Setter
@Entity
@Table(name = "ROLE")
@DynamicInsert
@DynamicUpdate
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色代码
     */
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    /**
     * 角色名称
     */
    @Column(name = "NAME")
    private String name;
}
