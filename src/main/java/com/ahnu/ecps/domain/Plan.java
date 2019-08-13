package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 授课教案
 * @author mxding
 * @date 2019-08-11
 */
@Getter
@Setter
@Entity
@Table(name = "PLAN")
@DynamicInsert
@DynamicUpdate
public class Plan {

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
    private Long sort;
}
