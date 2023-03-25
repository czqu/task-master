package net.czqu.taskmaster.sso.service;

import lombok.extern.slf4j.Slf4j;

import net.czqu.taskmaster.common.constant.error.ErrorCode;
import net.czqu.taskmaster.common.constant.exception.UserAccountException;
import net.czqu.taskmaster.common.dto.UserInfoDTO;
import net.czqu.taskmaster.dao.example.TmUserExample;
import net.czqu.taskmaster.dao.mapper.TmUserMapper;
import net.czqu.taskmaster.dao.pojo.TmRole;
import net.czqu.taskmaster.dao.pojo.TmUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 21:53
 **/
@Service
@Slf4j
public class TMUserService {
    private TmUserMapper tmUserMapper;
    private static final Integer uidLength = 5;

    @Autowired
    public TMUserService(TmUserMapper tmUserMapper) {
        this.tmUserMapper = tmUserMapper;
    }

    public TmUser getUserByUid(int uid) {
        return tmUserMapper.selectOneByExample(TmUserExample.newAndCreateCriteria()
                .andUidEqualTo(uid)
                .example());
    }

    public List<TmRole> getRoleByUser(TmUser user) {
        return null;
    }

    public void saveUser(TmUser user) {
        tmUserMapper.insert(user);
    }


    public int getNewUserId(int retry) throws UserAccountException {
        if (retry <= 0) {
            throw new UserAccountException("unknown error", ErrorCode.USER_UNKNOWN_ERROR);
        }
        int newUid = Integer.parseInt(RandomStringUtils.randomNumeric(uidLength));
        boolean res = tmUserMapper.selectOneByExample(TmUserExample.newAndCreateCriteria().andUidEqualTo(newUid).example()) != null;
        if (res) {
            return getNewUserId(--retry);
        }
        return newUid;
    }

    public UserInfoDTO getUserInfo(int uid) throws UserAccountException {
        TmUser user = tmUserMapper.selectOneByExample(TmUserExample.newAndCreateCriteria().andUidEqualTo(uid).example());
        if (user == null) {
            throw new UserAccountException("unknown error", ErrorCode.USER_NOT_FOUND);
        }

        return new UserInfoDTO(user.getUid(), user.getUsername(), user.getEmail(), user.getPhone());
    }
}
