package com.shuiyang.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 课程
 * @Author: mxding
 * @Date: 2019-07-23 14:30
 */
@Getter
@Setter
@Entity
@Table(name = "COURSE")
@DynamicInsert
@DynamicUpdate
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 课程代码
     */
    @Column(name = "CODE")
    private String code;
}
