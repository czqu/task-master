package net.czqu.taskmaster.dao.mapper;

import java.util.List;
import net.czqu.taskmaster.dao.example.AccessLogExample;
import net.czqu.taskmaster.dao.pojo.AccessLog;
import org.apache.ibatis.annotations.Param;

public interface AccessLogMapper {
    long countByExample(AccessLogExample example);

    int deleteByExample(AccessLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccessLog record);

    int insertSelective(@Param("record") AccessLog record, @Param("selective") AccessLog.Column ... selective);

    AccessLog selectOneByExample(AccessLogExample example);

    AccessLog selectOneByExampleSelective(@Param("example") AccessLogExample example, @Param("selective") AccessLog.Column ... selective);

    List<AccessLog> selectByExampleSelective(@Param("example") AccessLogExample example, @Param("selective") AccessLog.Column ... selective);

    List<AccessLog> selectByExample(AccessLogExample example);

    AccessLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") AccessLog.Column ... selective);

    AccessLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccessLog record, @Param("example") AccessLogExample example, @Param("selective") AccessLog.Column ... selective);

    int updateByExample(@Param("record") AccessLog record, @Param("example") AccessLogExample example);

    int updateByPrimaryKeySelective(@Param("record") AccessLog record, @Param("selective") AccessLog.Column ... selective);

    int updateByPrimaryKey(AccessLog record);

    int batchInsert(@Param("list") List<AccessLog> list);

    int batchInsertSelective(@Param("list") List<AccessLog> list, @Param("selective") AccessLog.Column ... selective);
}