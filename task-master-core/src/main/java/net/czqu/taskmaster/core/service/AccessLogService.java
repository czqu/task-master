package net.czqu.taskmaster.core.service;

import net.czqu.taskmaster.common.dto.ApiLogDTO;
import net.czqu.taskmaster.common.utils.IPUtils;
import net.czqu.taskmaster.dao.example.AccessLogExample;
import net.czqu.taskmaster.dao.mapper.AccessLogMapper;
import net.czqu.taskmaster.dao.pojo.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-29 21:19
 **/
@Service
public class AccessLogService {
    private final AccessLogMapper accessLogMapper;

    @Autowired
    public AccessLogService(AccessLogMapper accessLogMapper) {
        this.accessLogMapper = accessLogMapper;
    }

    public void setToAccessLog(ApiLogDTO logDTO) {
        if (logDTO == null) {
            return;
        }
        AccessLog accessLog = apiLogDTOToAccessLog(logDTO);
        if (accessLog != null) {
            accessLogMapper.insert(accessLog);
        }


    }

    public List<AccessLog> getAccessLogList(int num,int appid) {
        if (num < 0) {
            return new ArrayList<>();
        }
        return accessLogMapper.selectByExample(AccessLogExample.newAndCreateCriteria().andAppIdEqualTo((byte) appid).example().limit(num).orderBy(
                AccessLog.Column.time.asc()
        ));

    }

    private AccessLog apiLogDTOToAccessLog(ApiLogDTO logDTO) {
        if (logDTO == null) {
            return null;
        }
        AccessLog accessLog = new AccessLog();
        accessLog.setCostTime(Math.toIntExact(logDTO.getCostTime()));
        if (IPUtils.isValidIpv4Address(logDTO.getIp())) {
            accessLog.setRemoteIp(logDTO.getIp());
        }
        accessLog.setMethod(logDTO.getMethod());
        accessLog.setAppId((byte) logDTO.getAppId());
        accessLog.setParams(logDTO.getParams());
        accessLog.setProtocol(logDTO.getProtocol());
        accessLog.setRequestUri(logDTO.getRequestUri());
        accessLog.setTime(logDTO.getTime());
        accessLog.setHostName(logDTO.getHostName());
        accessLog.setStatusCode(logDTO.getStatusCode());
        accessLog.setId(logDTO.getUid());
        accessLog.setUserAgent(logDTO.getUserAgent());
        accessLog.setUserName(logDTO.getUserName());

        return accessLog;
    }
}
