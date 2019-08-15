package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 友情链接
 * @author dingmx
 * @date 2019/7/27 23:47
 */
@Getter
@Setter
@Entity
@Table(name = "LINK")
@DynamicInsert
@DynamicUpdate
public class Link {
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
     * 链接
     */
    @Column(name="URL")
    private String url;

    /**
     * 序号
     */
    @Column(name = "SORT")
    private Long sort;
}
