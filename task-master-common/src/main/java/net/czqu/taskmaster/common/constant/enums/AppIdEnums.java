package net.czqu.taskmaster.common.constant.enums;

import lombok.Getter;

/**
 * @author Paul
 */
@Getter
public enum AppIdEnums {
    SSO(1,"sso"),
    CORE(2,"core");
    private int id;
    private String name;


    AppIdEnums(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
