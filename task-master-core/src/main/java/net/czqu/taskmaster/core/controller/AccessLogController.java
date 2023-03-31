package net.czqu.taskmaster.core.controller;

import net.czqu.taskmaster.core.service.AccessLogService;
import net.czqu.taskmaster.dao.pojo.AccessLog;
import net.czqu.taskmaster.dao.pojo.Exchanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-29 21:58
 **/
@RestController
@RequestMapping("/log")
public class AccessLogController {
    private final AccessLogService accessLogService;
@Autowired
    public AccessLogController(AccessLogService accessLogService) {
        this.accessLogService = accessLogService;
    }

    @GetMapping
    public List<AccessLog> getList(
            @RequestParam(value = "num", defaultValue = "1")
            @Min(value = 0, message = "must >1")
            @Max(value = 100000, message = "must <100000")
            int num,
            @RequestParam(value="appId",defaultValue = "1")
            int appId
    ) {
        return accessLogService.getAccessLogList(num,appId);
    }
}
