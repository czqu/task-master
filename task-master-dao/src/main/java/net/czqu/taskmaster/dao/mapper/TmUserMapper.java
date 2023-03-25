package net.czqu.taskmaster.dao.mapper;

import java.util.List;

import net.czqu.taskmaster.dao.example.TmUserExample;
import net.czqu.taskmaster.dao.pojo.TmUser;
import org.apache.ibatis.annotations.Param;

public interface TmUserMapper {
    long countByExample(TmUserExample example);

    int deleteByExample(TmUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmUser record);

    int insertSelective(@Param("record") TmUser record, @Param("selective") TmUser.Column ... selective);

    TmUser selectOneByExample(TmUserExample example);

    TmUser selectOneByExampleSelective(@Param("example") TmUserExample example, @Param("selective") TmUser.Column ... selective);

    List<TmUser> selectByExampleSelective(@Param("example") TmUserExample example, @Param("selective") TmUser.Column ... selective);

    List<TmUser> selectByExample(TmUserExample example);

    TmUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") TmUser.Column ... selective);

    TmUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmUser record, @Param("example") TmUserExample example, @Param("selective") TmUser.Column ... selective);

    int updateByExample(@Param("record") TmUser record, @Param("example") TmUserExample example);

    int updateByPrimaryKeySelective(@Param("record") TmUser record, @Param("selective") TmUser.Column ... selective);

    int updateByPrimaryKey(TmUser record);

    int batchInsert(@Param("list") List<TmUser> list);

    int batchInsertSelective(@Param("list") List<TmUser> list, @Param("selective") TmUser.Column ... selective);
}