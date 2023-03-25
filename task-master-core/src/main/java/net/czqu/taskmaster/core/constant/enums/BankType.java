package net.czqu.taskmaster.core.constant.enums;

import lombok.Getter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 14:07
 **/
@Getter
public enum BankType {
    ICBC(1, "icbc");
    private int id;
    private String name;

    BankType(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
