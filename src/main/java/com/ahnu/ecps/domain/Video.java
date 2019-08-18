package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 教学视频
 * @author dingmx
 * @date 2019/7/27 23:47
 */
@Getter
@Setter
@Entity
@Table(name = "VIDEO")
@DynamicInsert
@DynamicUpdate
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 附件
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ATTACH_ID")
    private Attach attach;

    /**
     * 显示标题
     */
    @Column(name = "TITLE")
    private String title;

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
