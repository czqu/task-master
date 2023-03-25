package net.czqu.taskmaster.core.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:16
 **/
@Getter
@Setter
public class ApiLogDTO {

    private String method;
    private String protocol;
    private Integer statusCode;

    private String url;
    private String params;
    private String time;
    private String ip;
    private String userAgent;
    private Long bodySize;
    private Long costTime;


}
