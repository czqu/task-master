package net.czqu.taskmasterjwt.service;

import lombok.extern.slf4j.Slf4j;

import net.czqu.taskmasterdao.example.TmUserExample;
import net.czqu.taskmasterdao.mapper.TmUserMapper;
import net.czqu.taskmasterdao.pojo.TmRole;
import net.czqu.taskmasterdao.pojo.TmUser;
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

    @Autowired
    public TMUserService(TmUserMapper tmUserMapper) {
        this.tmUserMapper = tmUserMapper;
    }

    public TmUser getUserByUid(String uid) {
        return tmUserMapper.selectOneByExample(TmUserExample.newAndCreateCriteria()
                .andUidEqualTo(uid)
                .example());
    }
    public List<TmRole> getRoleByUser(TmUser user){
        return null;
    }
    public void saveUser(TmUser user){
        tmUserMapper.insert(user);
    }
    public String getSaltByUid(String uid)
    {
        return tmUserMapper.selectOneByExample(TmUserExample.newAndCreateCriteria().andUidEqualTo(uid).example()).getPasswordSalt();
    }
}
