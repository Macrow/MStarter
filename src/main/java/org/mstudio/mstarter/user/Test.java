package org.mstudio.mstarter.user;

import lombok.Data;

/**
 * @author Macrow
 * @date 2020/2/26
 */
@Data
public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }
}
