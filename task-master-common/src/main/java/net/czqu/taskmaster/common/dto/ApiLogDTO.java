package net.czqu.taskmaster.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:16
 **/
@Getter
@Setter
public class ApiLogDTO {

    private int appId;
    private String method;
    private String protocol;
    private Integer statusCode;
    private String hostName;
    private String requestUri;
    private int uid;
    private String UserName;
    private String params;
    private Date time;
    private String ip;
    private String userAgent;
    private Long bodySize;
    private Long costTime;


}
