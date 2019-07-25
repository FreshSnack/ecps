package com.shuiyang.ecps.domain;

import com.shuiyang.ecps.enumerate.PageViewType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 访问量
 * @Author: mxding
 * @Date: 2019-07-25 08:20
 */
@Getter
@Setter
@Entity
@Table(name = "PAGE_VIEW")
@DynamicInsert
@DynamicUpdate
public class PageView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 访问代码
     */
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    /**
     * 访问量名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 访问量
     */
    @Column(name = "VISIT_COUNT")
    private Long visitCount;

    public PageView() {}

    public PageView(String code) {
        this.code = code;
        PageViewType pageViewType = PageViewType.get(code);
        if(pageViewType != null) {
            this.name = pageViewType.name;
        }
        this.visitCount = 0L;
    }
}
