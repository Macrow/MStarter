package org.mstudio.mstarter.base;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author Macrow
 * @date 2020/2/25
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SnowFlakeGenerator")
    @GenericGenerator(name = "SnowFlakeGenerator", strategy = "org.mstudio.mstarter.base.SnowFlakeGenerator")
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Timestamp createTime;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime;
}
