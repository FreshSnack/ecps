package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 教学活动
 * @author mxding
 * @date 2019-08-13
 */
@Getter
@Setter
@Entity
@Table(name = "TEACHING")
@DynamicInsert
@DynamicUpdate
public class Teaching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 内容
     */
    @Column(name = "CONTENT", columnDefinition = "clob")
    private String content;

    /**
     * 发布人
     */
    @Column(name = "PUBLISH_USERNAME")
    private String publishUsername;

    /**
     * 发布时间
     */
    @Column(name = "PUBLISH_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishTime;
}
