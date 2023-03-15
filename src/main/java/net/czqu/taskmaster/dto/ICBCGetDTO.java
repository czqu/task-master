package net.czqu.taskmaster.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 13:51
 **/
@Getter
@Setter
public class ICBCGetDTO {
    private int code;
    private String message;
    private ICBCDTO[] data;

}
