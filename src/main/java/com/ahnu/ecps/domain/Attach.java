package com.ahnu.ecps.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 附件
 * @author dingmx
 * @date 2019/7/27 23:47
 */
@Getter
@Setter
@Entity
@Table(name = "ATTACH")
@DynamicInsert
@DynamicUpdate
public class Attach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 文件名
     */
    @Column(name = "FILE_NAME")
    private String fileName;

    /**
     * 文件存储路径
     */
    @Column(name = "PATH")
    private String path;
}
