package net.czqu.taskmasterdao.mapper;

import java.util.List;
import net.czqu.taskmasterdao.example.TmUserRoleExample;
import net.czqu.taskmasterdao.pojo.TmUserRole;
import org.apache.ibatis.annotations.Param;

public interface TmUserRoleMapper {
    long countByExample(TmUserRoleExample example);

    int deleteByExample(TmUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmUserRole record);

    int insertSelective(@Param("record") TmUserRole record, @Param("selective") TmUserRole.Column ... selective);

    TmUserRole selectOneByExample(TmUserRoleExample example);

    TmUserRole selectOneByExampleSelective(@Param("example") TmUserRoleExample example, @Param("selective") TmUserRole.Column ... selective);

    List<TmUserRole> selectByExampleSelective(@Param("example") TmUserRoleExample example, @Param("selective") TmUserRole.Column ... selective);

    List<TmUserRole> selectByExample(TmUserRoleExample example);

    TmUserRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") TmUserRole.Column ... selective);

    TmUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmUserRole record, @Param("example") TmUserRoleExample example, @Param("selective") TmUserRole.Column ... selective);

    int updateByExample(@Param("record") TmUserRole record, @Param("example") TmUserRoleExample example);

    int updateByPrimaryKeySelective(@Param("record") TmUserRole record, @Param("selective") TmUserRole.Column ... selective);

    int updateByPrimaryKey(TmUserRole record);

    int batchInsert(@Param("list") List<TmUserRole> list);

    int batchInsertSelective(@Param("list") List<TmUserRole> list, @Param("selective") TmUserRole.Column ... selective);
}