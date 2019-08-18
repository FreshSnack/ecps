package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 教学团队
 * @author mxding
 * @date 2019-08-11
 */
@Getter
@Setter
@Entity
@Table(name = "TEAM")
@DynamicInsert
@DynamicUpdate
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 照片附件
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ATTACH_ID")
    private Attach attach;

    /**
     * 图片链接
     */
    @Column(name = "LINK")
    private String link;

    /**
     * 序号
     */
    @Column(name = "SORT")
    private Long sort;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
