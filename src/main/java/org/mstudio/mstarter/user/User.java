package org.mstudio.mstarter.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.mstudio.mstarter.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Macrow
 * @date 2020/2/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sys_user")
public class User extends BaseEntity implements Serializable {
    @NotNull
    @NotEmpty
    private String name;

    @JsonIgnore
    private String password;

    private String nickName;
}
