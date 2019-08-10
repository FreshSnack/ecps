package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 访客留言
 * @author dingmx
 * @date 2019/7/28 13:53
 */
@Getter
@Setter
@Entity
@Table(name = "MESSAGE")
@DynamicInsert
@DynamicUpdate
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 留言内容
     */
    @Column(name = "CONTENT", nullable = false)
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
