package org.mstudio.mstarter.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mstudio.mstarter.base.BaseEntity;

import javax.persistence.Entity;
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
public class User extends BaseEntity implements Serializable {
    @NotNull
    @NotEmpty
    private String name;
}


