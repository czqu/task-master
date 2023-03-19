package net.czqu.taskmasterdao.mapper;

import java.util.List;
import net.czqu.taskmasterdao.example.TmRoleExample;
import net.czqu.taskmasterdao.pojo.TmRole;
import org.apache.ibatis.annotations.Param;

public interface TmRoleMapper {
    long countByExample(TmRoleExample example);

    int deleteByExample(TmRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmRole record);

    int insertSelective(@Param("record") TmRole record, @Param("selective") TmRole.Column ... selective);

    TmRole selectOneByExample(TmRoleExample example);

    TmRole selectOneByExampleSelective(@Param("example") TmRoleExample example, @Param("selective") TmRole.Column ... selective);

    List<TmRole> selectByExampleSelective(@Param("example") TmRoleExample example, @Param("selective") TmRole.Column ... selective);

    List<TmRole> selectByExample(TmRoleExample example);

    TmRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") TmRole.Column ... selective);

    TmRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmRole record, @Param("example") TmRoleExample example, @Param("selective") TmRole.Column ... selective);

    int updateByExample(@Param("record") TmRole record, @Param("example") TmRoleExample example);

    int updateByPrimaryKeySelective(@Param("record") TmRole record, @Param("selective") TmRole.Column ... selective);

    int updateByPrimaryKey(TmRole record);

    int batchInsert(@Param("list") List<TmRole> list);

    int batchInsertSelective(@Param("list") List<TmRole> list, @Param("selective") TmRole.Column ... selective);
}