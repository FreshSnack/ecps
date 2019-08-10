package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 地貌图片
 * @author mxding
 * @date 2019-08-10
 */
@Getter
@Setter
@Entity
@Table(name = "GEO_PICTURE")
@DynamicInsert
@DynamicUpdate
public class GeoPicture {

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
     * 序号
     */
    @Column(name = "SORT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sort;
}
