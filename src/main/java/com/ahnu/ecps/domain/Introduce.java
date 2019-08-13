package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 课程简介
 * @author mxding
 * @date 2019-08-13
 */
@Getter
@Setter
@Entity
@Table(name = "INTRODUCE")
@DynamicInsert
@DynamicUpdate
public class Introduce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程介绍内容
     */
    @Column(name = "CONTENT", columnDefinition = "clob")
    private String content;
}
